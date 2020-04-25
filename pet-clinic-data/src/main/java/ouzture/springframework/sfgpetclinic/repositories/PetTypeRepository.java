package ouzture.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ouzture.springframework.sfgpetclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType,Long> {
}
