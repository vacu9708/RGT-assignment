package com.rgt.rgt.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rgt.rgt.order.dto.OrderDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class OrderService {
    final OrderRepository orderRepository;
    ResponseEntity<String> order(OrderDto orderDto) {
        if(orderDto.getProductName().equals("카페테리아"))
            orderDto.setProductName("카페라떼");
        String responseMsg;
        try{
            orderRepository.insertOrder(orderDto);
            responseMsg = new ObjectMapper().writeValueAsString(orderDto);
        } catch(Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body("Error");
        }
        responseMsg = "<pre>" + responseMsg + "<pre/> 주문번호 : "+orderDto.getOrderId()+" 수신";
        return ResponseEntity.ok(responseMsg);
    }

    ResponseEntity<String> deleteDuplicates() {
        try{
            orderRepository.deleteDuplicatesExceptOneByOrderId();
            return ResponseEntity.ok("Success");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }

    ResponseEntity<String> updateCafeteria(){
        try{
            orderRepository.updateCafeteria();
            return ResponseEntity.ok("Success");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body("Error");
        }
    }
}
