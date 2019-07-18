package co.sys.reinv.daood.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import co.sys.reinv.daood.model.Article;

public interface ArticleRepository extends PagingAndSortingRepository<Article, Long> {

}
