package co.com.bancolombia.api;

import co.com.bancolombia.api.dto.CrearFranquiciaRequest;
import co.com.bancolombia.api.dto.CrearProductoRequest;
import co.com.bancolombia.api.dto.CrearSucursalRequest;
import co.com.bancolombia.model.franquicia.Franquicia;
import co.com.bancolombia.model.producto.Producto;
import co.com.bancolombia.model.sucursal.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface Mappings {

    @Mapping(target = "id", ignore = true)
    Franquicia toFranquicia(CrearFranquiciaRequest request);

    @Mapping(target = "id", ignore = true)
    Sucursal toSucursal(CrearSucursalRequest request);

    @Mapping(target = "id", ignore = true)
    Producto toProducto(CrearProductoRequest request);

}
