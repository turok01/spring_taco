package com.Igor.spring_taco.data;

import com.Igor.spring_taco.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository <Order, Long> {
    //Order save(Order order);
}
