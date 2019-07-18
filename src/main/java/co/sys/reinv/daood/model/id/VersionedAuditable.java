package co.sys.reinv.daood.model.id;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class VersionedAuditable extends Auditable {
	
	@Version
	private Long version;

}
