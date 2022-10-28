package com.example.demo.owner;

import com.example.demo.dog.Dog;
import com.example.demo.dog.DogRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final DogRepository dogRepository;

    public OwnerService(OwnerRepository ownerRepository, DogRepository dogRepository) {
        this.ownerRepository = ownerRepository;
        this.dogRepository = dogRepository;
    }
    public List<Owner> getOwners(){
        return ownerRepository.findAll();
    }

    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }
    public void addNewDogForOwner(Dog dog, Long ownerID){
        Owner owner = ownerRepository.findById(ownerID).get();
        List<Dog> dogList = new ArrayList<>();
        dogList.add(dog);
        owner.setDogList(dogList);
        ownerRepository.saveAndFlush(owner);
    }


    public void deleteOwner(Long id) {
        boolean exists = ownerRepository.existsById(id);
        if(!exists){
            throw new IllegalStateException(
                    "Owner with id " + id + " does not exist"
            );
        }
        ownerRepository.deleteById(id);
    }

    @Transactional
    public void updateOwner(Long id, String name, Integer age) {
        Owner owner = ownerRepository.findById(id).
                orElseThrow(()-> new IllegalStateException("Owner with id "+ id + " doesn't exist"));

        owner.setName(name);
    }
}
