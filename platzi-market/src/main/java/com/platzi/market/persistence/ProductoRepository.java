package com.platzi.market.persistence;

import java.util.List;
import java.util.Optional;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;

import org.springframework.stereotype.Repository;

@Repository
public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getProducts() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getProductosByCategoria(int categoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidadStock) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidadStock, true);
    }

    public Optional<Producto> getProducto(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    public Producto saveProducto(Producto producto) {
        return productoCrudRepository.save(producto);
    }

    public void deleteProducto(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}