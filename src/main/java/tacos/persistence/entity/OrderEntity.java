package tacos.persistence.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TACO_ORDER")
public class OrderEntity extends AbstractEntity{
	
	private LocalDate placedAt;
	
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserEntity user;

	@NotBlank(message = "Name is required")
	private String name;

	@NotBlank(message = "Street is required")
	private String street;

	@NotBlank(message = "City is required")
	private String city;

	@NotBlank(message = "State is required")
	private String state;

	@NotBlank(message = "Zip code is required")
	private String zip;

	@CreditCardNumber(message = "Not a valid credit card number")
	@Column(name = "CC_NUMBER")
	private String ccNumber;

	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
	@Column(name = "CC_EXPIRATION")
	private String ccExpiration;
	
	@Digits(integer=3, fraction=0, message="Invalid CVV")
	@Column(name = "CC_CVV")
	private String ccCVV;
	
	@ManyToMany
	@JoinTable(name = "ORDER_TO_TACO", joinColumns = @JoinColumn(name = "ORDER_ID"), inverseJoinColumns = @JoinColumn(name = "TACO_ID"))
	private List<TacoEntity> tacos = new ArrayList<>();
	
	public void addTaco(TacoEntity taco){
		this.tacos.add(taco);
	}
	
	@PrePersist
	public void placedAt(){
		this.placedAt = LocalDate.now();
	}

}
