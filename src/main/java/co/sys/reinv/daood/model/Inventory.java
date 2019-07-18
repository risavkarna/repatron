package co.sys.reinv.daood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

//import co.sys.reinv.daood.model.bi.EndUserInventory;
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
public class Inventory extends VersionedAuditable {
	
	@NotBlank
	private String name;
	
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@Default
	@OneToMany(mappedBy = "inventory")
	private List<Article> articles = new ArrayList<>();
	
//	@Default
//	@OneToMany(mappedBy = "inventory")
//	private List<EndUserInventory> endUserInventories = new ArrayList<>();
	
	public Boolean add(Article article) {
		if (!this.articles.contains(article)) {
			article.setInventory(this);
			return this.articles.add(article);
		}
		return false;
	}
	
	public Boolean remove(Article article) {
		article.setInventory(null);
		return this.articles.remove(article);
	}
}
