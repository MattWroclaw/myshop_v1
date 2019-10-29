package com.mateusz.shopv1.myshop_v1.service;

import com.mateusz.shopv1.myshop_v1.repository.ProductRepository;
import com.mateusz.shopv1.myshop_v1.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Collection<Product> findAll(String filter)
    { if(StringUtils.isEmpty(filter)) {
        return productRepository.findAll();
    }
    return productRepository.findAllByTitleLike("%"+filter+"%");
    }

    public Product find(Long id )
    {  return productRepository.findById(id).orElseThrow(
            ()->new EntityNotFoundException("No such product..")
    ) ;
    }

    public Product editProduct(Product product){
        Product updatedProduct = productRepository.findById(product.getId())
                .orElseThrow( ()-> new EntityNotFoundException("No such product"));
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setInitialStockAmount(product.getInitialStockAmount());
        updatedProduct.setTitle(product.getTitle());
        updatedProduct.setStockAmount(product.getStockAmount());
        productRepository.save(updatedProduct);
        return updatedProduct;
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public void delete(Long id){
       Product deletedProduct = productRepository.findById(id)
                .orElseThrow(
                        ()-> new EntityNotFoundException("No such product")
                );
       productRepository.delete(deletedProduct);
    }



}
