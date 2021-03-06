package com.example.karton.service.impl;

import com.example.karton.model.Product;
import com.example.karton.repo.ProductRepository;
import com.example.karton.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
@Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getOne(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> filter(List<String> productName, List<String> category, List<Integer> prices) {
        List<Product> productList;

        if (!prices.isEmpty()){
            productList = productRepository.findByPriceBetweenOrderByPriceDesc(prices.get(0), prices.get(1));
        }else if (!productName.isEmpty() && !category.isEmpty()){
            productList = productRepository.findByProductNameInAndProductCategoryInOrderByPriceDesc(productName,category);
        }else if (!productName.isEmpty() || !category.isEmpty()){
            productList = productRepository.findByProductNameInOrProductCategoryInOrderByPriceDesc(productName,category);
        }else {
            productList = productRepository.findAll();
        }
        return productList;
    }

    @Override
    public List<Product> findByProductOrderByPriceDesc(String productName) {
        return productRepository.findByProductNameOrderByPriceDesc(productName);
    }

    @Override
    public List<Product> findByProductOrderByCategoryDesc(String productCategory) {
        return productRepository.findByProductCategoryOrderByPriceDesc(productCategory);
    }

    @Override
    public void saveProductInfoById(String productName, String category, String description, String filename, Integer price, String quantity, Long id) {


productRepository.saveProductInfoById(productName,category,description,filename,price,quantity,id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }
}
