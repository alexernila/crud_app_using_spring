package com.example.demo.dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path="/api/v1")
public class DogController {

    @Autowired
    private final DogService dogService;

    public DogController(DogService dogService){
        this.dogService = dogService;
    }

    @GetMapping("/getAllDogs")
    public List<Dog> getDogs(){return dogService.getDogs();
    }

    @PostMapping("/registerDog")
    public void registerNewDog(@RequestBody Dog dog){
        dogService.addDog(dog);
    }

    @DeleteMapping(path = "/deleteDog/{dogId}")
    public void deleteDog(@PathVariable("dogId") Long dogId){
        dogService.deleteDog(dogId);
    }

    @PutMapping(path = "/updateDog/{dogId}")
    public void updateDog(
            @PathVariable("dogId") Long dogId,
            @RequestParam(required = false) String breed,
            @RequestParam(required = false) Integer age){
        dogService.updateDog(dogId, breed, age);
    }

}
