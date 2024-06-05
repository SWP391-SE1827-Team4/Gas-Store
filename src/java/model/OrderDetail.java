/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Van Minh Tuan
 */
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetail {

    private int product_quantity;
    private Order order;
    private Product product;
    private double price;

    private int id;
    private String status;
    private Date paymentDate;
    private String paymentMethod;

    public OrderDetail(int product_quantity, Order order, Product product, double price) {
        this.product_quantity = product_quantity;
        this.order = order;
        this.product = product;
        this.price = price;
    }

}
