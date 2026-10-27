package kr.ac.kopo.minn.bookmarket.repository;


import kr.ac.kopo.minn.bookmarket.domain.Order;

public interface OrderRepository {
    Long saveOrder(Order order);
}
