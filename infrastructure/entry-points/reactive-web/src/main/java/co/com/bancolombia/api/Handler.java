package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.CrearFranquiciaRequest;
import co.com.bancolombia.api.dto.CrearProductoRequest;
import co.com.bancolombia.api.dto.CrearSucursalRequest;
import co.com.bancolombia.usecase.franchise.FranchiseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class Handler {
    private final FranchiseUseCase franchiseUseCase;
    private final Mappings mappings;

    public Mono<ServerResponse> crearFranquicia(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CrearFranquiciaRequest.class)
                .map(mappings::toFranquicia)
                .flatMap(franchiseUseCase::crearFranquicia)
                .flatMap(response -> ServerResponse.ok().bodyValue(response.toString()));
    }

    public Mono<ServerResponse> crearSucursal(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CrearSucursalRequest.class)
                .map(mappings::toSucursal)
                .flatMap(franchiseUseCase::crearSucursal)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }

    public Mono<ServerResponse> crearProducto(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(CrearProductoRequest.class)
                .map(mappings::toProducto)
                .flatMap(franchiseUseCase::crearProducto)
                .flatMap(response -> ServerResponse.ok().bodyValue(response));
    }
}
