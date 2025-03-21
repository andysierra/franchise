package co.com.asierra.usecase.franchise;

import co.com.asierra.model.franquicia.Franquicia;
import co.com.asierra.model.franquicia.gateways.FranquiciaRepository;
import co.com.asierra.model.producto.Producto;
import co.com.asierra.model.sucursal.Sucursal;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FranchiseUseCase {

    private final FranquiciaRepository franquiciaRepository;

    public Mono<Franquicia> crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia);
    }

    public Mono<String> crearSucursal(Sucursal sucursal) {
        return Mono.just("creando la pinshi sucursal: "+sucursal.toString());
    }

    public Mono<String> crearProducto(Producto producto) {
        return Mono.just("agregando pinshi producto: "+producto.toString());
    }
}
