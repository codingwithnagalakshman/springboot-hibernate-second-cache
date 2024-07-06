package com.techbrothers99.springboothibernatesecondcache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Cacheable(value = "product", key = "#productId", condition = "#productId < 3")
    public Product getProductById(Long productId){
        return productRepository.findById(productId).get();
    }
}
