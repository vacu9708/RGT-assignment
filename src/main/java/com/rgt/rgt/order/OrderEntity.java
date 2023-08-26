package com.rgt.rgt.order;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderEntity {
    @Id
    String Id;
    String orderId;
    String productName;
    String options;
    int tableNo;
    int quantity;
    Date orderDate;
    Time orderTime;
    Timestamp dateTime;
    String robotStatus;
    int dong;
    int ho;
    String seq;
    String ordererName;
}
