package com.rgt.rgt.order;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rgt.rgt.order.dto.OrderDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class OrderController {
    final OrderService OrderService;
    
    @PostMapping("/order")
    ResponseEntity<String> order(@RequestBody OrderDto orderDto) {
        return OrderService.order(orderDto);
    }

    @DeleteMapping("/deleteDuplicates")
    ResponseEntity<String> deleteDuplicates() {
        return OrderService.deleteDuplicates();
    }

    @PatchMapping("/updateCafeteria")
    ResponseEntity<String> updateCafeteria() {
        return OrderService.updateCafeteria();
    }
}
