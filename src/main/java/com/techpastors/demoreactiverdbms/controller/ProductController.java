package com.techpastors.demoreactiverdbms.controller;

import com.techpastors.demoreactiverdbms.model.Product;
import com.techpastors.demoreactiverdbms.service.ProductService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

/**
 * The traditional way to handle the rest endpoints
 */

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public Flux<Product> getAll() {
        return this.productService.getAllProducts();
    }

    @PostMapping("/save")
    public Mono<Product> updateProduct(@RequestBody Product product) {
        return Objects.isNull(product.getId()) ?
                this.productService.createProduct(product) :
                this.productService.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteProduct(@PathVariable int id) {
        return this.productService.deleteProduct(id);
    }

}
