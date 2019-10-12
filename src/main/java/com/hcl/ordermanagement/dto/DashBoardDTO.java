package com.hcl.ordermanagement.dto;

import java.util.List;

public class DashBoardDTO {

	List<OrderDTO> buyOrders;
	List<OrderDTO> sellOrders;
	
	public List<OrderDTO> getBuyOrders() {
		return buyOrders;
	}
	public void setBuyOrders(List<OrderDTO> buyOrders) {
		this.buyOrders = buyOrders;
	}
	public List<OrderDTO> getSellOrders() {
		return sellOrders;
	}
	public void setSellOrders(List<OrderDTO> sellOrders) {
		this.sellOrders = sellOrders;
	}
	
	
}
