package com.example.demo.dog;

import com.example.demo.owner.Owner;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;

@Entity
@Table(name = "dog")
public class Dog {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    private String breed;
    private Integer age;

    public Dog() {
    }

    public Dog(Long id, String breed, Integer age) {
        this.id = id;
        this.breed = breed;
        this.age = age;
    }

    public Dog( String breed, Integer age) {
//        this.ownerId = ownerId;
        this.breed = breed;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", breed='" + breed + '\'' +
                ", age=" + age +
                '}';
    }
}
