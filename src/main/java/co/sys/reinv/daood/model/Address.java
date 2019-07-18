package co.sys.reinv.daood.model;

import javax.persistence.Entity;

import co.sys.reinv.daood.model.id.IdEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Address extends IdEntity {
	
	private String street;
	
	private String houseNumber;
	
	private Integer postalCode;
	
	private String city;
	
	private String country;
	
}
