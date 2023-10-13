package com.example.services;

import com.example.dao.entities.Product;
import com.example.dao.repositiories.ProductRepository;
import com.example.model.ProductResource;
import com.example.services.mappers.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {
    private final String PRODUCT_NOT_FOUND = "Product not found";

    private final ProductRepository repository;

    ProductResource createProduct(ProductResource resource){
        Product newProduct = repository.save(ProductMapper.MAPPER.mapToProduct(resource));
        return ProductMapper.MAPPER.mapToProductResource(newProduct);

    }

    ProductResource getProductById(Integer id){
        Optional<Product> product = repository.findById(id);
        if (product.isPresent())
            return ProductMapper.MAPPER.mapToProductResource(product.get());
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, PRODUCT_NOT_FOUND);
    }

    void deleteProduct(Integer id){
        repository.deleteById(id);
    }
}
