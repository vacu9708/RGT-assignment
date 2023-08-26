package com.rgt.rgt.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rgt.rgt.order.dto.OrderDto;

import jakarta.transaction.Transactional;

@Transactional
public interface OrderRepository extends JpaRepository<OrderEntity, String>{
    @Modifying
    @Query(value = "INSERT INTO orders (order_id, product_name, options, table_no, quantity, order_date, order_time, date_time, robot_status, dong, ho, seq, orderer_name) "+
        "VALUES (:#{#o.orderId}, :#{#o.productName}, :#{#o.options}, :#{#o.tableNo}, :#{#o.quantity}, :#{#o.orderDate}, :#{#o.orderTime}, :#{#o.dateTime}, :#{#o.robotStatus}, :#{#o.dong}, :#{#o.ho}, :#{#o.seq}, :#{#o.ordererName})",
        nativeQuery = true)
    void insertOrder(@Param("o") OrderDto orderDto);

    // @Query(value = "DELETE o1 FROM orders o1 LEFT JOIN ("+
    //     "SELECT MIN(id) as minId FROM orders GROUP BY orderId) o2 "+
    //     "ON o1.id = o2.minId WHERE o2.minId IS NULL", nativeQuery = true)
    // @Query(value = "DELETE o1 FROM orders o1 JOIN ("+
    //     "SELECT orderId, MIN(dateTime) as earliestDateTime FROM orders "+
    //     "GROUP BY orderId HAVING COUNT(orderId) > 1) o2 ON "+
    //     "o1.orderId = o2.orderId AND o1.dateTime != o2.earliestDateTime", nativeQuery = true)
    @Query(value = "DELETE o1 FROM orders o1 JOIN ("+
        "SELECT MIN(id) as min_id, order_id FROM orders GROUP BY order_id) o2 "+
        "ON o1.id != o2.min_id and o1.order_id = o2.order_id", nativeQuery = true)
    @Modifying
    void deleteDuplicatesExceptOneByOrderId();

    @Modifying
    @Query(value = "UPDATE orders SET product_name = '카페라떼' WHERE product_name = '카페테리아'", nativeQuery = true)
    void updateCafeteria();
}