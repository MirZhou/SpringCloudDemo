package cn.eros.cloud.mall.service;

import cn.eros.cloud.mall.dto.bo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * <p>create time：2020-08-25 10:15
 *
 * @author Eros
 */
@FeignClient("PRODUCT-SERVICE")
public interface ProductService {
    @GetMapping("/products")
    List<Product> findAll();

    @GetMapping("/product/{itemCode}")
    Product getByItemCode(@PathVariable String itemCode);
}
