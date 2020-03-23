package com.Igor.spring_taco.data;

import com.Igor.spring_taco.Order;

public interface OrderRepository {
    Order save(Order order);
}
