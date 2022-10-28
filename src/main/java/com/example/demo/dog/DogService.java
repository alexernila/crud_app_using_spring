package com.example.demo.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class DogService {

    private final DogRepository dogRepository;

    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<Dog> getDogs(){return dogRepository.findAll();
    }

    public void addDog(Dog dog) {
        dogRepository.save(dog);
    }

    public void deleteDog(Long dogId) {
        boolean exists = dogRepository.existsById(dogId);
        if(!exists){
            throw new IllegalStateException(
                    "Dog with id " + dogId + " does not exist"
            );
        }
        dogRepository.deleteById(dogId);
    }

    @Transactional
    public void updateDog(Long dogId, String breed, Integer age) {
        Dog dog = dogRepository.findById(dogId).
                orElseThrow(()-> new IllegalStateException("Dog with id "+ dogId + " doesn't exist"));
            dog.setAge(age);
    }
}
