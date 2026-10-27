package kr.ac.kopo.minn.bookmarket.repository;


import kr.ac.kopo.minn.bookmarket.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProRepository extends JpaRepository<Order, Long> {
}