package ouzture.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ouzture.springframework.sfgpetclinic.model.Owner;
import ouzture.springframework.sfgpetclinic.model.Pet;
import ouzture.springframework.sfgpetclinic.model.PetType;
import ouzture.springframework.sfgpetclinic.model.Vet;
import ouzture.springframework.sfgpetclinic.services.OwnerService;
import ouzture.springframework.sfgpetclinic.services.PetTypeService;
import ouzture.springframework.sfgpetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {


        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Nuray Sk.");
        owner1.setCity("Istanbul");
        owner1.setTelephone("023332345");

        Pet o1p1 = new Pet();
        o1p1.setPetType(savedDogPetType);
        o1p1.setName("Buck");
        o1p1.setOwner(owner1);
        o1p1.setBirthDate(LocalDate.now());
        owner1.getPets().add(o1p1);

        Pet o1p2 = new Pet();
        o1p2.setPetType(savedDogPetType);
        o1p2.setName("Pebble");
        o1p2.setOwner(owner1);
        o1p2.setBirthDate(LocalDate.now());
        owner1.getPets().add(o1p2);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Gleanne");
        owner2.setAddress("Losers Blv");
        owner2.setCity("Seattle");
        owner2.setTelephone("22342443");

        Pet o2p1 = new Pet();
        o2p1.setPetType(savedCatPetType);
        o2p1.setName("Misty");
        o2p1.setOwner(owner2);
        o2p1.setBirthDate(LocalDate.now());
        owner2.getPets().add(o2p1);


        ownerService.save(owner2);

        System.out.println("Loaded owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lady");
        vet2.setLastName("Gaga");

        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
