package cn.eros.cloud.mall.controller;

import cn.eros.cloud.mall.service.ProductService;
import cn.eros.cloud.product.api.entity.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>create time：2020-08-25 10:22
 *
 * @author Eros
 */
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> list() {
        return this.productService.findAll();
    }

    @GetMapping("/product/{itemCode}")
    public Product detail(@PathVariable String itemCode) {
        return this.productService.getByItemCode(itemCode);
    }
}
