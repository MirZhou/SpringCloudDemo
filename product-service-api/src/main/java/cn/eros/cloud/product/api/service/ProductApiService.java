package cn.eros.cloud.product.api.service;

import cn.eros.cloud.product.api.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>create time：2020-08-25 11:56
 *
 * @author Eros
 */
public interface ProductApiService {
    @GetMapping("/products")
    List<Product> findAll();

    @GetMapping("/product/{itemCode}")
    Product getByItemCode(@PathVariable String itemCode);
}
