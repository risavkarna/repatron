package co.sys.reinv.daood.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

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
//TODO @EntityGraph
public class EndUser extends VersionedAuditable {
	
	@Column(unique = true, nullable = true)
	@Size(min = 5)
	private String username;
	
	@Size(min = 6)
	private String password;
	
	@OneToOne(orphanRemoval = true)
	@JoinColumn(name = "personInfo_id")
	private PersonInfo personInfo;
	
	@Default
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private Set<UserRole> userRoles = new HashSet<>(Arrays.asList(UserRole.GUEST));
	
//	@Default
//	@OneToMany(mappedBy = "endUser")
//	private List<EndUserInventory> endUserInventories = new ArrayList<>();
//	
//	public Boolean add(Inventory inventory) {
//		EndUserInventory endUserInventory = new EndUserInventory(this, inventory);
//		if (!endUserInventories.contains(endUserInventory)) {
//			return endUserInventories.add(endUserInventory) 
//					&& inventory.getEndUserInventories().add(endUserInventory);
//		}
//		return false;
//	}
//	
//	public Boolean remove(Inventory inventory) {
//		Boolean removed = false;
//		for (Iterator<EndUserInventory> iterator = endUserInventories.iterator(); 
//				iterator.hasNext();) {
//			EndUserInventory endUserInventory = iterator.next();
//			if (endUserInventory.getInventory().equals(inventory) 
//					&& endUserInventory.getEndUser().equals(this)) {
//				iterator.remove();
//				inventory.getEndUserInventories().remove(endUserInventory);
//				endUserInventory.setEndUser(null);
//				endUserInventory.setInventory(null);
//				removed = true;
//			}
//		}
//		return removed;
//	}
	
	public String getUsername() {
		if ((username == null || username.isEmpty()) 
				&& (personInfo != null)) {
			return personInfo.getEmail();
		}
		return username;
	}
	
}
