
package co.sys.reinv.daood.model.bi;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Embeddable
public class EndUserInventoryId implements Serializable {

	private static final long serialVersionUID = 3347691012406816700L;

	@NonNull
	private Long endUserId;

	@NonNull
	private Long inventoryId;

}
