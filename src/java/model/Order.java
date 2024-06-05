/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Van Minh Tuan
 */
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
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
public class Order {

    private int id;
    private Date created_date;
    private User user;

    private List<OrderDetail> orderDetails = new ArrayList<>();
    private String status;
    
    //contructor 
    public Order(Date created_date, User user) {
        this.created_date = created_date;
        this.user = user;
    }

    public Order(int id, Date created_date, User user) {
        this.id = id;
        this.created_date = created_date;
        this.user = user;
    }

    public int getTotalPrice() {
        int total = 0;

        for (OrderDetail orderDetail : orderDetails) {
            total += orderDetail.getPrice();
        }
        return total;
    }

}
