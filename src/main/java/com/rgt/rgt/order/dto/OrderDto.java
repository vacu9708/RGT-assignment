package com.rgt.rgt.order.dto;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class OrderDto {
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