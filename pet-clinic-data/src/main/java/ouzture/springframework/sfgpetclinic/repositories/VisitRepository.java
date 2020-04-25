package ouzture.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ouzture.springframework.sfgpetclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit,Long> {
}
