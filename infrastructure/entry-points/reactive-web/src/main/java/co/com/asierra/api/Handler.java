package co.com.asierra.api;

import co.com.asierra.api.request.CrearFranquiciaRequest;
import co.com.asierra.api.request.CrearProductoRequest;
import co.com.asierra.api.request.CrearSucursalRequest;
import co.com.asierra.api.response.ServerResponses;
import co.com.asierra.usecase.franchise.FranchiseUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class Handler {
    private final FranchiseUseCase franchiseUseCase;
    private final Mappings mappings;

    // pendiente validaciones

    public Mono<ServerResponse> crearFranquicia(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CrearFranquiciaRequest.class)
                .map(mappings::toFranquicia)
                .flatMap(franchiseUseCase::crearFranquicia)
                .flatMap(response ->
                        ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(response));
    }

    public Mono<ServerResponse> crearSucursal(ServerRequest serverRequest) {
        Mono<CrearSucursalRequest> flow = serverRequest.bodyToMono(CrearSucursalRequest.class).cache();

        return flow
                .map(mappings::toSucursal)
                .flatMap(franchiseUseCase::crearSucursal)
                .flatMap(response -> ServerResponse.ok().bodyValue(response))
                .onErrorResume(error -> ServerResponses.onError(error, flow));
    }

    public Mono<ServerResponse> crearProducto(ServerRequest serverRequest) {
        Mono<CrearProductoRequest> flow = serverRequest.bodyToMono(CrearProductoRequest.class).cache();

        return flow
                .flatMap(req -> franchiseUseCase.buscarSucursalPorId(req.getSucursalId())
                        .flatMap(sucursal -> franchiseUseCase.crearProducto(mappings.toProducto(req), sucursal)))
                .flatMap(response -> ServerResponse.ok().bodyValue(response))
                .onErrorResume(error -> ServerResponses.onError(error, flow));
    }
}
