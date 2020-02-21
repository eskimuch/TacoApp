package tacos.web.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.persistence.entity.IngredientEntity;
import tacos.persistence.entity.OrderEntity;
import tacos.persistence.entity.TacoEntity;
import tacos.persistence.entity.UserEntity;
import tacos.persistence.entity.enumerations.IngredientType;
import tacos.persistence.repository.IngredientRepository;
import tacos.persistence.repository.TacoRepository;
import tacos.persistence.repository.UserRepository;
import tacos.web.constans.ViewNames;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

	private TacoRepository tacoRepository;
	private IngredientRepository ingredientRepository;
	private UserRepository userRepository;

	public DesignTacoController(TacoRepository tacoRepository, IngredientRepository ingredientRepository, UserRepository userRepository) {
		this.tacoRepository = tacoRepository;
		this.ingredientRepository = ingredientRepository;
		this.userRepository = userRepository;
	}

	@ModelAttribute(name = "order")
	public OrderEntity order() {
		return new OrderEntity();
	}

	@ModelAttribute(name = "design")
	public TacoEntity design() {
		return new TacoEntity();
	}

	@GetMapping
	public String showDesignForm(Model model, Principal principal) {
		log.info("   --- Designing taco");
		List<IngredientEntity> ingredients = new ArrayList<>();
		ingredientRepository.findAll().forEach(i -> ingredients.add(i));

		IngredientType[] types = IngredientType.values();
		for (IngredientType type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		
		String username = principal.getName();
		UserEntity user = userRepository.findByUsername(username);
		model.addAttribute("user", user);

		return ViewNames.DESIGN;
	}

	@PostMapping
	public String processDesign(@Valid TacoEntity taco, Errors errors, @ModelAttribute OrderEntity order) {
		log.info("   --- Saving taco");
		
		if (errors.hasErrors()) {
			return ViewNames.DESIGN;
		}

		TacoEntity saved = tacoRepository.save(taco);
		order.addTaco(saved);

		log.info("Processing design: " + taco);
		return "redirect:/orders/current";
	}

	private List<IngredientEntity> filterByType(List<IngredientEntity> ingredients, IngredientType type) {
		return ingredients.stream().filter(x -> x.getIngredientType().equals(type)).collect(Collectors.toList());
	}
}
