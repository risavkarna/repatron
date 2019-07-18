package co.sys.reinv.daood.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import co.sys.reinv.daood.model.id.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
public class PurchaseItem extends Auditable {

	@Size(max = 200)
	private String orderSummary;
	
	@Size(max = 200)
	private String deliverySummary;
	
	private BigDecimal cost;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;

}
