package tacos.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TACO")
public class TacoEntity extends AbstractEntity{
	
	private LocalDate createdAt;

	@NotNull
	@Size(min=5, message="Name must be at least 5 characters long")
	private String name;
	
	@ManyToMany
	@JoinTable(name = "TACO_TO_INGREDIENT", joinColumns = @JoinColumn(name = "TACO_ID"), inverseJoinColumns = @JoinColumn(name = "INGREDIENT_ID"))
	@Size(min=1, message="You must choose at least 1 ingredient")
	private List<IngredientEntity> ingredients;
	
	@PrePersist
	public void createdAt(){
		this.createdAt = LocalDate.now();
	}

}
