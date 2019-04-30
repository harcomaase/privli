package de.mh.privli.boundary.entity.repository;

import de.mh.privli.boundary.entity.LinkEntry;
import org.springframework.data.repository.CrudRepository;

public interface LinkEntryRepository extends CrudRepository<LinkEntry, Integer> {

    LinkEntry findByLinkAlias(String linkAlias);
}
