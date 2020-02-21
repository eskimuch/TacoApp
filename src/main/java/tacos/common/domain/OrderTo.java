package tacos.common.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderTo {
	
	private Long id;
	
	private LocalDate placedAt;

	private String name;

	private String street;

	private String city;

	private String state;

	private String zip;

	private String ccNumber;

	private String ccExpiration;
	
	private String ccCVV;
	
	private List<Long> tacos = new ArrayList<>();

}
