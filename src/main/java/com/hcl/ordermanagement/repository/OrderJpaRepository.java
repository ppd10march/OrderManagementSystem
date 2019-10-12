package com.hcl.ordermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.ordermanagement.dto.OrderDTO;

public interface OrderJpaRepository extends JpaRepository<OrderDTO, Long>{

	
}
