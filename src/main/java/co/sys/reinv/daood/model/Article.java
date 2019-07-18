package co.sys.reinv.daood.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import co.sys.reinv.daood.model.id.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Article extends Auditable {
	
	@NotBlank
	private String name;
	
	@Default
	private Integer count = 1;
	
	@Size(max = 50)
	private String description;
	
	@NotNull
	private BigDecimal pricePerUnit;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inventory_id")
	private Inventory inventory;

}
