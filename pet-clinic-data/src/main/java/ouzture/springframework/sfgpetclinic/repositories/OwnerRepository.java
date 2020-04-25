package ouzture.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ouzture.springframework.sfgpetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner,Long> {
}
