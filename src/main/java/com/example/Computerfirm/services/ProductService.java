package com.example.Computerfirm.services;

import com.example.Computerfirm.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private long ID = 0;


    public List<Product> listProducts() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void deleteProduct(Long id) {
        products.removeIf(product -> product.getId() == ID);
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId() == ID) return product;
        }
        return null;
    }
}
