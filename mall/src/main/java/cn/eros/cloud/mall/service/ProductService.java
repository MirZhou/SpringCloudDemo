package cn.eros.cloud.mall.service;

import cn.eros.cloud.product.api.service.ProductApiService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * <p>create time：2020-08-25 10:15
 *
 * @author Eros
 */
@FeignClient("PRODUCT-SERVICE")
public interface ProductService extends ProductApiService {
}
