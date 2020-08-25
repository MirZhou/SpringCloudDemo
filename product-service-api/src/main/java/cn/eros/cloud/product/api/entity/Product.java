package cn.eros.cloud.product.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p>create time：2020-08-25 09:34
 *
 * @author Eros
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    /**
     * 产品货号
     */
    private String itemCode;
    /**
     * 产品名称
     */
    private String name;
    /**
     * 产品品牌名称
     */
    private String bandName;
    /**
     * 产品价格(分)
     */
    private int price;
}
