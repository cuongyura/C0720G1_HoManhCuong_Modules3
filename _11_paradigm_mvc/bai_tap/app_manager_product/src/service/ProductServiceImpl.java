package service;

import module.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> productMap;

    static {
         productMap = new HashMap<>();
         productMap.put(1, new Product(1,"Banana1",32,"MVP","Miền Nam"));
         productMap.put(2, new Product(2,"Banana2",19,"MVP","Miền Bắc"));
         productMap.put(3, new Product(3,"Banana3",25,"MVP","Nam Trung Bộ"));
         productMap.put(4, new Product(4,"Banana4",36,"MVP","Tây Bắc"));
         productMap.put(5, new Product(5,"Banana5",20,"MVP","Tây Nguyên"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList(productMap.values());
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void saveProduct(Product product) {
       productMap.put(product.getId(), product);
    }

    @Override
    public void editProduct(int id, Product product) {
       productMap.put(id, product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }
}
