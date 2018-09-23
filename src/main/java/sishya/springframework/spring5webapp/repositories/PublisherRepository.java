package sishya.springframework.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import sishya.springframework.spring5webapp.model.Publisher;

/*
 * created by NR on 23 Sep 2018
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
