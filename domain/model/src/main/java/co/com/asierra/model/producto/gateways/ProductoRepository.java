package co.com.asierra.model.producto.gateways;

import co.com.asierra.model.producto.Producto;
import reactor.core.publisher.Mono;

public interface ProductoRepository {
    Mono<Producto> save(Producto producto);
    Mono<Producto> findById(Integer id);
    public Mono<Producto> findOne(Producto entity);
}
