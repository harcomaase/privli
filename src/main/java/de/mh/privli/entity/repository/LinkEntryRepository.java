package de.mh.privli.entity.repository;

import de.mh.privli.entity.LinkEntry;
import org.springframework.data.repository.CrudRepository;

public interface LinkEntryRepository extends CrudRepository<LinkEntry, Integer> {

    LinkEntry findByLinkAlias(String linkAlias);
}
