package co.sys.reinv.daood.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.sys.reinv.daood.model.id.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Builder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//TODO @EntityGraph
public class Purchase extends Auditable {
	
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
		
	private BigDecimal totalPaid;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patron_id")
	private Patron patron;
	
	@Default
	@OneToMany(mappedBy = "purchase")
	private List<PurchaseItem> purchaseItems = new ArrayList<>();

}
