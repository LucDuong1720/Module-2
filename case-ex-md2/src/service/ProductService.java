package service;

import model.Product;
import utils.FileUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProductService implements IProductService{
    public final String pathProduct = "./data/products.csv";

    @Override
    public List<Product> getAllProdutcs() {
        return FileUtils.readData(pathProduct, Product.class);
    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = getAllProdutcs();
        long lastId = 1;
        if(products.size()!=0){
            Product lastCustomer = products.get(products.size()-1);
            lastId = lastCustomer.getId()+1;
        }
        product.setId(lastId);

        products.add(product);

        FileUtils.writeDataToFile(pathProduct, products);
    }

    @Override
    public void deleteProductById(long id) {
        List<Product> products = getAllProdutcs();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
            }
        }
        FileUtils.writeDataToFile(pathProduct, products);
    }

    @Override
    public void updateProductById(long id, Product product) {
        List<Product> products = getAllProdutcs();
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                products.get(i).setName(product.getName());
                products.get(i).setBrand(product.getBrand());
                products.get(i).setOrigin(product.getOrigin());
                products.get(i).setCapacity(product.getCapacity());
                products.get(i).setQuantity(product.getQuantity());
                products.get(i).setPrice(product.getPrice());
            }
        }
        FileUtils.writeDataToFile(pathProduct, products);
    }

    @Override
    public void sortByPrice() {
        List<Product> productList = getAllProdutcs();
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getPrice() > o2.getPrice()) {
                    return 1;
                } else if (o1.getId() == o2.getId()) {
                    return 0;
                }else {
                    return -1;
                }
            }
        });
        FileUtils.writeDataToFile(pathProduct, productList);
    }

    @Override
    public void sortByName() {
        List<Product> products = getAllProdutcs();
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    @Override
    public void searchByName() {

    }

}
