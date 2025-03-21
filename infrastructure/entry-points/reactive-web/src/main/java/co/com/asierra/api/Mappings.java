package co.com.asierra.api;

import co.com.asierra.api.dto.CrearFranquiciaRequest;
import co.com.asierra.api.dto.CrearProductoRequest;
import co.com.asierra.api.dto.CrearSucursalRequest;
import co.com.asierra.model.franquicia.Franquicia;
import co.com.asierra.model.producto.Producto;
import co.com.asierra.model.sucursal.Sucursal;
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
