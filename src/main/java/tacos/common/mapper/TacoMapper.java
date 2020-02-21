package tacos.common.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import tacos.common.domain.TacoTo;
import tacos.persistence.entity.IngredientEntity;
import tacos.persistence.entity.TacoEntity;
import tacos.persistence.repository.IngredientRepository;

@Component
public class TacoMapper {

	private IngredientRepository ingredientRepository;

	public TacoTo mapToTacoTo(TacoEntity taco) {
		TacoTo tacoTo = new TacoTo();
		tacoTo.setName(taco.getName());
		tacoTo.setCreatedAt(taco.getCreatedAt());
		tacoTo.setIngredients(mapToIngredientsTo(taco.getIngredients()));
		return tacoTo;
	}

	public TacoEntity mapToTaco(TacoTo tacoTo) {
		TacoEntity taco = new TacoEntity();
		taco.setName(tacoTo.getName());
		taco.setCreatedAt(tacoTo.getCreatedAt());
		if (!tacoTo.getIngredients().isEmpty()) {
			taco.setIngredients(ingredientRepository.findAllById(tacoTo.getIngredients()));
		}
		return taco;
	}

	private List<String> mapToIngredientsTo(List<IngredientEntity> ingredients) {
		if (ingredients == null) {
			return new ArrayList<>();
		}
		return ingredients.stream().map(IngredientEntity::getId).collect(Collectors.toList());
	}

}
