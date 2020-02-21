package tacos.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tacos.persistence.entity.enumerations.IngredientType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IngredientTo {
	
	private String id;
	
	private String name;
	
	private IngredientType ingredientType;

}
