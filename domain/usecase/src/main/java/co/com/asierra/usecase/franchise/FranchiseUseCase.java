package co.com.asierra.usecase.franchise;

import co.com.asierra.model.franquicia.Franquicia;
import co.com.asierra.model.franquicia.gateways.FranquiciaRepository;
import co.com.asierra.model.producto.Producto;
import co.com.asierra.model.producto.gateways.ProductoRepository;
import co.com.asierra.model.sucursal.Sucursal;
import co.com.asierra.model.sucursal.gateways.SucursalRepository;
import co.com.asierra.model.sucursalproducto.SucursalProducto;
import co.com.asierra.model.sucursalproducto.gateways.SucursalProductoRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class FranchiseUseCase {

    private final FranquiciaRepository franquiciaRepository;
    private final SucursalRepository sucursalRepository;
    private final ProductoRepository productoRepository;
    private final SucursalProductoRepository sucursalProductoRepository;

    public Mono<Franquicia> crearFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(franquicia).onErrorResume(Mono::error);
    }

    public Mono<Sucursal> crearSucursal(Sucursal sucursal) {
        return franquiciaRepository.findById(sucursal.getFranquiciaId())
                .then(sucursalRepository.save(sucursal));
    }

    public Mono<Sucursal> buscarSucursalPorId(Integer id) {
        return sucursalRepository.findById(id);
    }

    public Mono<Map<String, String>> crearProducto(Producto producto, Sucursal sucursal) {
        return buscarProductoPorNombre(producto.getNombre())
                .switchIfEmpty(productoRepository.save(producto))
                .flatMap(foundProduct -> {
                    System.out.println("buscaré sucursal con datos: "+foundProduct.getId()+", "+sucursal.getId());
                    return sucursalProductoRepository.findOne(SucursalProducto.builder()
                            .productoId(foundProduct.getId())
                            .sucursalId(sucursal.getId())
                            .build())
                            .switchIfEmpty(sucursalProductoRepository.save(SucursalProducto.builder()
                                    .productoId(foundProduct.getId())
                                    .sucursalId(sucursal.getId())
                                    .stock(0L)
                                    .build()));
                })
                .flatMap(obtainedSucursalProducto -> {
                    obtainedSucursalProducto.setStock(obtainedSucursalProducto.getStock()+1);
                    return sucursalProductoRepository.save(obtainedSucursalProducto);
                })
                .flatMap(updatedSucursalProducto -> {
                    System.out.println("found sucursal: "+updatedSucursalProducto);
                    return Mono.just(Map.of());
                });
    }

    public Mono<Producto> buscarProductoPorNombre(String nombre) {
        return productoRepository.findOne(Producto.builder().nombre(nombre).build());
    }
}
