package com.example.demo.owner;

import com.example.demo.dog.Dog;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;

    @OneToMany(targetEntity = Dog.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "dog", referencedColumnName = "id")
    private List<Dog> dogList;

    public Owner() {
    }

    public Owner(Long id, String name, Integer age, List<Dog> dogList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.dogList = dogList;
    }

    public Owner(String name, Integer age, List<Dog> dogList) {
        this.name = name;
        this.age = age;
        this.dogList = dogList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Dog> getDogList() {
        return dogList;
    }


    public void setDogList(List<Dog> dogList) {
        if(this.dogList == null) {
            this.dogList = dogList;
        }else{
            for(Dog d : dogList){
                this.dogList.add(d);
            }
        }
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", dogList=" + dogList +
                '}';
    }
}