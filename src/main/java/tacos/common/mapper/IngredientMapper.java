package tacos.common.mapper;

import org.springframework.stereotype.Component;

import tacos.common.domain.IngredientTo;
import tacos.persistence.entity.IngredientEntity;

@Component
public class IngredientMapper {

	public IngredientTo mapToIngredientTo(IngredientEntity ingredient) {
		IngredientTo ingredientTo = new IngredientTo();
		ingredientTo.setName(ingredient.getName());
		ingredientTo.setIngredientType(ingredient.getIngredientType());
		return ingredientTo;
	}

	public IngredientEntity mapToIngredient(IngredientTo ingredientTo) {
		IngredientEntity ingredient = new IngredientEntity();
		ingredient.setName(ingredientTo.getName());
		ingredient.setIngredientType(ingredientTo.getIngredientType());
		return ingredient;
	}

}
