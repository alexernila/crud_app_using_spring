package com.example.demo.owner;

import com.example.demo.dog.Dog;
import com.example.demo.dog.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class OwnerController {
    @Autowired
    private final OwnerService ownerService;

    @Autowired
    private final DogService dogService;

    public OwnerController(OwnerService ownerService, DogService dogService){
        this.ownerService = ownerService;
        this.dogService = dogService;
    }

    @GetMapping("/getAllOwners")
    public List<Owner> getOwners(){
        return ownerService.getOwners();
    }

    @PostMapping("/registerOwner")
    public void registerNewOwner(@RequestBody Owner owner){
        ownerService.addOwner(owner);
    }

    @DeleteMapping(path = "/deleteOwner/{id}")
    public void deleteDog(@PathVariable("id") Long id){
        ownerService.deleteOwner(id);
    }

    @PutMapping(path = "/updateOwner/{id}")
    public void updateOwner(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age){
        ownerService.updateOwner(id, name, age);
    }

    @PostMapping(path = "/addNewDogForOwner/{id}")
    public void addNewDogForOwner(
            @PathVariable("id") Long ownerId,
            @RequestParam(required = false) String breed,
            @RequestParam(required = false) Integer age){
        ownerService.addNewDogForOwner(new Dog(breed, age), ownerId);
    }

}
