package com.market.place.persistence.mapper;

import com.market.place.domain.Category;
import com.market.place.domain.Product;
import com.market.place.persistence.entity.Categoria;
import com.market.place.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

//Metodo MapStruck

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
abstract
class CategoryMapper {
    @Mappings(value = {
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),
    })
    public abstract Product toProduct(Producto producto);
    public abstract List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    public abstract Producto toProducto(Product product);
}
