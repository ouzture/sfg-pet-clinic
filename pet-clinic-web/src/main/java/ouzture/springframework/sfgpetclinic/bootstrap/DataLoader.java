package ouzture.springframework.sfgpetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ouzture.springframework.sfgpetclinic.model.*;
import ouzture.springframework.sfgpetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0){
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(radiology);

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

        Visit visit1 = new Visit();
        visit1.setPet(o1p1);
        visit1.setDate(LocalDate.now());
        visit1.setDescription("visitors V");
        visitService.save(visit1);

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
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lady");
        vet2.setLastName("Gaga");
        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded vets....");
    }
}
