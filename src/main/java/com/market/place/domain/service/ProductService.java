package com.market.place.domain.service;

import com.market.place.domain.Product;
import com.market.place.domain.repository.ProductRepository;
import jakarta.persistence.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Identificacion de Capa de servicio
@Service
public class ProductService {
    //Instancia de Interface de product Repository
    @Autowired
    private ProductRepository productRepository;

    //Metodo que obtiene la lista de productos
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId) {
        return productRepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productRepository.getByCategory(categoryId);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }
    //Consulta eliminacion se utiliza
    public boolean delete(int productId) {
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}