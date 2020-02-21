package tacos.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tacos.persistence.entity.enumerations.IngredientType;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "INGREDIENT")
public class IngredientEntity {
	
	@Id
	private String id;
	private String name;
	
	@Column(name = "INGREDIENT_TYPE", nullable = false)
	@Enumerated(EnumType.STRING)
	private IngredientType ingredientType;

}
