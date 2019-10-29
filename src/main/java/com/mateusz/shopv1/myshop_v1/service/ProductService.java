package com.mateusz.shopv1.myshop_v1.service;

import com.mateusz.shopv1.myshop_v1.entity.Product;
import com.mateusz.shopv1.myshop_v1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

//    public List<Product> findOldVer(String filter){
//        if(StringUtils.isEmpty(filter)){
//            return productRepository.findAll();
//        }
//        return productRepository.findAllByDescriptionLike("%"+filter+"%");
//    }
    //      TODO rozkminić o co chodzi z tym filtrowaniem
    public List<Product> findAll(String filter,
                                 Integer pageIndex,
                                 Integer pageSize,
                                 String direction,
                                 String sortColumn) {
//  to jest na wzór tego z zajęć... niestety nie działa :(
        //        log.info("poczatek metody");
//        Sort.Direction sortDirection = Sort.Direction.fromString(direction);
//        Sort sort = Sort.by(sortDirection, sortColumn);
//        Pageable page = PageRequest.of(pageIndex, pageSize, sort);
//        log.info("srodek metody");
//        if (StringUtils.isEmpty(filter)) {
//            return productRepository.findAll(page).getContent();
//        }
//        return productRepository.findAllByTitleLike("%" + filter + "%", page);

        if(!StringUtils.isEmpty(filter)){
            Sort.Direction sortDirection = Sort.Direction.fromString(direction);
            Sort sort = Sort.by(sortDirection, sortColumn);
            Pageable page = PageRequest.of(pageIndex, pageSize, sort);
            return productRepository.findAllByTitleLike("%" + filter + "%", page);
        }  return productRepository.findAll();
    }

    public Product find(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("No such product..")
        );
    }

    public Product editProduct(Product product) {
        Product updatedProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new EntityNotFoundException("No such product"));
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setInitialStockAmount(product.getInitialStockAmount());
        updatedProduct.setTitle(product.getTitle());
        updatedProduct.setStockAmount(product.getStockAmount());
        updatedProduct.setProductCategory(product.getProductCategory());
        productRepository.save(updatedProduct);
        return updatedProduct;
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No such product")
                );
        productRepository.delete(deletedProduct);
    }


}
