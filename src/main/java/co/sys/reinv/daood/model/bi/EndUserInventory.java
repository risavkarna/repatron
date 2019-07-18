
package co.sys.reinv.daood.model.bi;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import co.sys.reinv.daood.model.EndUser;
import co.sys.reinv.daood.model.Inventory;
import co.sys.reinv.daood.model.id.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
@Entity
public class EndUserInventory extends Auditable implements Serializable {

	@EmbeddedId
	private EndUserInventoryId endUserInventoryId;

	@MapsId("endUserId")
	@ManyToOne(fetch = FetchType.LAZY)
	private EndUser endUser;

	@MapsId("inventoryId")
	@ManyToOne(fetch = FetchType.LAZY)
	private Inventory inventory;

	public EndUserInventory(EndUser endUser, Inventory inventory) {
		this.endUser = endUser;
		this.inventory = inventory;
		this.endUserInventoryId = new EndUserInventoryId(endUser.getId(), inventory.getId());
	}

}
