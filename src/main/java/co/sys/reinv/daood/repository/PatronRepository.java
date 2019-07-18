package co.sys.reinv.daood.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import co.sys.reinv.daood.model.Patron;

@RepositoryRestResource
public interface PatronRepository extends PagingAndSortingRepository<Patron, Long>{

}
