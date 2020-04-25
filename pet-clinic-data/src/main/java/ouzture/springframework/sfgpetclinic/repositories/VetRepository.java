package ouzture.springframework.sfgpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import ouzture.springframework.sfgpetclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet,Long> {
}
