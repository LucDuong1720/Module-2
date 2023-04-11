package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProdutcs();
    void addProduct (Product product);
    void deleteProductById(long id);
    void updateProductById(long id, Product product);
    void sortByPrice();
    void sortByName();
    void searchByName();
}
