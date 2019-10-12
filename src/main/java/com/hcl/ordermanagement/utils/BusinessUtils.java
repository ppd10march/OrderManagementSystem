package com.hcl.ordermanagement.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.hcl.ordermanagement.dto.OrderDTO;

public class BusinessUtils {

	public static List<OrderDTO> mergeOrders(List<OrderDTO> orders) {
		List<Double> prices = new ArrayList<>();
		List<OrderDTO> sortedOrders = new ArrayList<OrderDTO>();
		for (int i = 0; i < orders.size() - 1; i++) {
			OrderDTO firstDTO = orders.get(i);
			if (prices.contains(firstDTO.getPrice())) {
				continue;
			}
			for (int j = i + 1; j < orders.size(); j++) {
				OrderDTO secondDTO = orders.get(j);
				if (firstDTO.getPrice() == secondDTO.getPrice()) {
					firstDTO.setQuantity(firstDTO.getQuantity() + secondDTO.getQuantity());
				}
			}
			sortedOrders.add(firstDTO);
		}
		Comparator<OrderDTO> compareById = (OrderDTO o1, OrderDTO o2) -> Double.compare(o1.getPrice(), o2.getPrice());
		Collections.sort(sortedOrders, compareById);
		return sortedOrders;
	}
}
