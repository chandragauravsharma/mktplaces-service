package com.mktplace.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mktplace.model.Product;
import com.mktplace.model.ProductCreationRequest;
import com.mktplace.model.ProductCreationResponse;
import com.mktplace.model.dto.ProductDTO;
import com.mktplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductService {
    @Autowired
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public ProductService(ProductRepository productRepository, ObjectMapper objectMapper) {
        this.productRepository = productRepository;
        this.objectMapper = objectMapper;
    }

    public Mono<ProductCreationResponse> createProduct(Mono<ProductCreationRequest> productCreationRequest) {
        return productCreationRequest.flatMap(request -> {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setUserId(request.getUserId());
            productDTO.setName(request.getName());
            productDTO.setDescription(request.getDescription());
            productDTO.setBasePrice(request.getBasePrice());
            productDTO.setQuantityAvailable(request.getQuantityAvailable());

            return productRepository.save(productDTO)
                    .map(savedProduct -> {
                        ProductCreationResponse response = new ProductCreationResponse();
                        response.setStatus(ProductCreationResponse.StatusEnum.SUCCESS);
                        response.setUser(objectMapper.convertValue(savedProduct, Product.class));
                        return response;
                    });
        });
    }

    public Flux<Product> getAllProducts() {
        return productRepository.findAll()
                .map(productDTO -> {
                    Product product = new Product();
                    product.setProductId(productDTO.getProductId());
                    product.setUserId(productDTO.getUserId());
                    product.setName(productDTO.getName());
                    product.setDescription(productDTO.getDescription());
                    product.setBasePrice(productDTO.getBasePrice());
                    product.setQuantityAvailable(productDTO.getQuantityAvailable());

                    return product;
                });
    }

    public Flux<Product> getAllProductsByUserId(String userId) {
        return productRepository.findByUserId(userId)
                .map(productDTO -> {
                    Product product = new Product();
                    product.setProductId(productDTO.getProductId());
                    product.setUserId(productDTO.getUserId());
                    product.setName(productDTO.getName());
                    product.setDescription(productDTO.getDescription());
                    product.setBasePrice(productDTO.getBasePrice());
                    product.setQuantityAvailable(productDTO.getQuantityAvailable());

                    return product;
                });
    }

    public Mono<Product> getProductById(Long productId) {
        return productRepository.findById(Math.toIntExact(productId))
                .map(productDTO -> {
                    Product product = new Product();
                    product.setProductId(productDTO.getProductId());
                    product.setUserId(productDTO.getUserId());
                    product.setName(productDTO.getName());
                    product.setDescription(productDTO.getDescription());
                    product.setBasePrice(productDTO.getBasePrice());
                    product.setQuantityAvailable(productDTO.getQuantityAvailable());

                    return product;
                });
    }
}
