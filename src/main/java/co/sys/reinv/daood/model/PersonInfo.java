package co.sys.reinv.daood.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import co.sys.reinv.daood.model.id.VersionedAuditable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class PersonInfo extends VersionedAuditable {
	
	public enum Gender {
		MALE,
		FEMALE,
		OTHER
	}

	@Email
	private String email;
	
	@NotBlank
	private String firstName;
	
	private String lastName;
	
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "address_id")
	private Address address;
	
	private Integer age;
	
	private Gender gender;
	
	private Integer phoneNumber;

}
