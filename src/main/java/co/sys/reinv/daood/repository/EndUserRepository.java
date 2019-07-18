package co.sys.reinv.daood.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import co.sys.reinv.daood.model.EndUser;

@RepositoryRestResource
public interface EndUserRepository extends PagingAndSortingRepository<EndUser, Long> {
	
}
