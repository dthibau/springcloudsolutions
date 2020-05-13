package org.formation.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.formation.model.Member;
import org.formation.model.Order;
import org.formation.model.OrderItem;
import org.formation.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public Order addOrderItem(Member member, OrderItem orderItem) {
		Order order = null;
		if ( orderItem.getOrder() == null ) {
			order = new Order(0, LocalDate.now(), LocalDate.now().plusDays(5), null, member, new ArrayList<OrderItem>());
			orderRepository.save(order);
			
		} else {
			order = orderRepository.findById(orderItem.getOrder().getId()).orElseThrow(() -> new OrderNotFoundException(""+orderItem.getOrder().getId()));
		}
		order.addOrderItem(orderItem);
		return orderRepository.save(order);
	}
}
