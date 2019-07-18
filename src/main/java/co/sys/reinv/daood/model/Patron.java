package co.sys.reinv.daood.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import co.sys.reinv.daood.model.id.VersionedAuditable;

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
public class Patron extends VersionedAuditable {
	
	@Temporal(TemporalType.DATE)
	private Date joined;
	
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "personInfo_id")
	private PersonInfo personInfo;
	
	@Default
	@OneToMany(mappedBy = "patron")
	private List<Purchase> purchases = new ArrayList<>();
	
	private BigDecimal totalPaid;
	
	private BigDecimal totalDue;

}
