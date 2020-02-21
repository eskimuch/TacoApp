package tacos.common.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tacos.common.domain.OrderTo;
import tacos.persistence.entity.OrderEntity;
import tacos.persistence.entity.TacoEntity;
import tacos.persistence.repository.TacoRepository;

@Component
public class OrderMapper {

	private TacoRepository tacoRepository;

	public OrderTo mapToOrderTo(OrderEntity order) {
		OrderTo orderTo = new OrderTo();
		orderTo.setPlacedAt(order.getPlacedAt());
		orderTo.setName(order.getName());
		orderTo.setStreet(order.getStreet());
		orderTo.setCity(order.getCity());
		orderTo.setState(order.getState());
		orderTo.setZip(order.getZip());
		orderTo.setCcNumber(order.getCcNumber());
		orderTo.setCcExpiration(order.getCcExpiration());
		orderTo.setCcCVV(order.getCcCVV());
		orderTo.setTacos(getTacosId(order.getTacos()));
		return orderTo;
	}

	public OrderEntity mapToOrder(OrderTo orderTo) {
		OrderEntity order = new OrderEntity();
		order.setPlacedAt(orderTo.getPlacedAt());
		order.setName(orderTo.getName());
		order.setStreet(orderTo.getStreet());
		order.setCity(orderTo.getCity());
		order.setState(orderTo.getState());
		order.setZip(orderTo.getZip());
		order.setCcNumber(orderTo.getCcNumber());
		order.setCcExpiration(orderTo.getCcExpiration());
		order.setCcCVV(orderTo.getCcCVV());
		order.setTacos(tacoRepository.findAllById(orderTo.getTacos()));
		return order;
	}

	private List<Long> getTacosId(List<TacoEntity> taco) {
		if (taco == null) {
			return new ArrayList<>();
		}
		return taco.stream().map(TacoEntity::getId).collect(Collectors.toList());
	}

}
