package co.com.asierra.model.sucursalproducto.gateways;

import co.com.asierra.model.sucursalproducto.SucursalProducto;
import reactor.core.publisher.Mono;

public interface SucursalProductoRepository {
    Mono<SucursalProducto> save(SucursalProducto sucursalProducto);
    Mono<SucursalProducto> findOne(SucursalProducto sucursalProducto);
    Mono<Long> countAllBySucursalIdAndProductoId(Integer sucursalId, Integer productoId);
}
