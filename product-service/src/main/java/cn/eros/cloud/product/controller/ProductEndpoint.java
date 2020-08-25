package cn.eros.cloud.product.controller;

import cn.eros.cloud.product.api.entity.Product;
import cn.eros.cloud.product.api.service.ProductApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <p>create time：2020-08-25 09:30
 *
 * @author Eros
 */
@Slf4j
@RestController
public class ProductEndpoint implements ProductApiService {
    @Override
    @GetMapping("/products")
    public List<Product> findAll() {
        return this.buildProducts();
    }

    @Override
    @GetMapping("/product/{itemCode}")
    public Product getByItemCode(@PathVariable String itemCode) {
        return this.buildProducts().stream()
                .filter(item -> itemCode.equalsIgnoreCase(item.getItemCode()))
                .findFirst()
                .orElse(new Product());
    }

    private List<Product> buildProducts() {
        return IntStream.rangeClosed(1, 7)
                .mapToObj(i -> {
                    Product product = new Product();
                    product.setItemCode("item-" + i);
                    product.setName("测试商品-" + i);
                    product.setBandName("Media in China");
                    product.setPrice(i * 100);

                    return product;
                })
                .collect(Collectors.toList());
    }
}
