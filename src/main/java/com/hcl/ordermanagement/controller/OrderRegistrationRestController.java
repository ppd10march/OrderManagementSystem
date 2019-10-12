package com.hcl.ordermanagement.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ordermanagement.dto.DashBoardDTO;
import com.hcl.ordermanagement.dto.OrderDTO;
import com.hcl.ordermanagement.repository.OrderJpaRepository;
import com.hcl.ordermanagement.utils.BusinessUtils;

@RestController
@RequestMapping("/api/order")
public class OrderRegistrationRestController {

	public static final Logger logger = LoggerFactory.getLogger(OrderRegistrationRestController.class);
	
	private OrderJpaRepository orderJpaRepository;
	
	@Autowired
	public void setOrderJpaRepository(OrderJpaRepository orderJpaRepository) {
		this.orderJpaRepository = orderJpaRepository;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<OrderDTO>> getAllOrders(){
		List<OrderDTO> orders = orderJpaRepository.findAll();
		return new ResponseEntity<List<OrderDTO>>(orders,HttpStatus.OK);	
	}
	
	@PostMapping(value="/",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderDTO> registerOrder(@RequestBody final OrderDTO order){
		orderJpaRepository.save(order);
		return new ResponseEntity<OrderDTO>(order, HttpStatus.CREATED);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderDTO> getOrderById(@PathVariable final Long id){
		Optional<OrderDTO> order = orderJpaRepository.findById(id);
		OrderDTO orders = order.get();
		return new ResponseEntity<OrderDTO>(orders,HttpStatus.OK);	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<OrderDTO> deleteOrder(@PathVariable final Long id){
		orderJpaRepository.deleteById(id);
		return new ResponseEntity<OrderDTO>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/home")
	public ResponseEntity<DashBoardDTO> createDashboard(){
		List<OrderDTO> orders = orderJpaRepository.findAll();
		List<OrderDTO> buyorders = new ArrayList<OrderDTO>();
		List<OrderDTO> sellorders = new ArrayList<OrderDTO>();
		List<OrderDTO> mergedBuyorders,mergedSellorders;
		
		DashBoardDTO dashboardDTO = new DashBoardDTO();
		for (OrderDTO order : orders) {
			if ("BUY".equals(order.getType())) {
				buyorders.add(order);
			} else {
				sellorders.add(order);
			}
		}
		mergedBuyorders = BusinessUtils.mergeOrders(buyorders);
		mergedSellorders = BusinessUtils.mergeOrders(sellorders);
		Collections.reverse(mergedSellorders);
		dashboardDTO.setBuyOrders(mergedBuyorders);
		dashboardDTO.setSellOrders(mergedSellorders);		
		return new ResponseEntity<DashBoardDTO>(dashboardDTO,HttpStatus.OK);	
	}
}
