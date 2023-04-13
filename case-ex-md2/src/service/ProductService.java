package service;

import model.Product;
import utils.DateUtils;
import utils.FileUtils;

import java.util.*;

public class ProductService implements IProductService {
    public final String pathProduct = "./data/products.csv";

    @Override
    public List<Product> getAllProdutcs() {
        return FileUtils.readData(pathProduct, Product.class);
    }

    @Override
    public void addProduct(Product product) {
        List<Product> products = getAllProdutcs();
        long lastId = 1;
        if (products.size() != 0) {
            Product lastProduct = products.get(products.size() - 1);
            lastId = lastProduct.getId() + 1;
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
                products.get(i).setCreatAt(DateUtils.parseDate(String.valueOf(new Date())));
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
                } else if (o1.getPrice() == o2.getPrice()) {
                    return 0;
                } else {
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
    public void sortByQuantity() {
        List<Product> productList = getAllProdutcs();
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getQuantity() > o2.getQuantity()) {
                    return 1;
                } else if (o1.getQuantity() == o2.getQuantity()) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        FileUtils.writeDataToFile(pathProduct, productList);

    }

    @Override
    public List<Product> findByName(String value) {
        List<Product> products = getAllProdutcs();
        List<Product> productsFind = new ArrayList<>();
        for (Product item : products) {
            if ((item.getName().toUpperCase()).contains(value.toUpperCase())) {
                productsFind.add(item);
            }
        }
        if (productsFind.isEmpty()) {
            return null;
        }
        return productsFind;
    }

    @Override
    public Product findById(long id) {
        List<Product> products = getAllProdutcs();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByBrand(String value) {
        List<Product> products = getAllProdutcs();
        List<Product> productsFind = new ArrayList<>();
        for (Product item : products) {
            if ((item.getBrand().toUpperCase()).contains(value.toUpperCase())) {
                productsFind.add(item);
            }
        }
        if (productsFind.isEmpty()) {
            return null;
        }
        return productsFind;
    }

    @Override
    public List<Product> findByOrigin(String value) {
        List<Product> products = getAllProdutcs();
        List<Product> productsFind = new ArrayList<>();
        for (Product item : products) {
            if ((item.getOrigin().toUpperCase()).contains(value.toUpperCase())) {
                productsFind.add(item);
            }
        }
        if (productsFind.isEmpty()) {
            return null;
        }
        return productsFind;
    }

}
