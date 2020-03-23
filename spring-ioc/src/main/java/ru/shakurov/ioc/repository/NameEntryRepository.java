package ru.shakurov.ioc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.shakurov.ioc.model.NameEntry;

@Repository
public interface NameEntryRepository extends JpaRepository<NameEntry, Long> {
}
