package service;

import module.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product findById(int id);
    void saveProduct(Product product);
    void editProduct(int id , Product product);
    void remove(int id);

}
