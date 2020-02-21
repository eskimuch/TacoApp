package tacos.web.controller;

import javax.validation.Valid;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.persistence.entity.OrderEntity;
import tacos.persistence.entity.UserEntity;
import tacos.persistence.repository.OrderRepository;
import tacos.web.constans.ViewNames;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

	private OrderRepository orderRepository;

	public OrderController(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	@GetMapping("/current")
	public String orderForm(@AuthenticationPrincipal UserEntity user, @ModelAttribute OrderEntity order) {
		if (order.getName() == null) {
			order.setName(user.getFullname());
		}
		if (order.getStreet() == null) {
			order.setStreet(user.getStreet());
		}
		if (order.getCity() == null) {
			order.setCity(user.getCity());
		}
		if (order.getState() == null) {
			order.setState(user.getState());
		}
		if (order.getZip() == null) {
			order.setZip(user.getZip());
		}

		return ViewNames.ORDER_FORM;
	}

	@PostMapping
	public String processOrder(@Valid OrderEntity order, Errors errors, SessionStatus sessionStatus,
			@AuthenticationPrincipal UserEntity user) {
		if (errors.hasErrors()) {
			return ViewNames.ORDER_FORM;
		}

		order.setUser(user);

		orderRepository.save(order);
		sessionStatus.setComplete();

		log.info("Zamówienie zostało złożone: " + order);
		return "redirect:/";
	}

}
