package com.example.demo;

import com.example.demo.dog.Dog;
import com.example.demo.owner.Owner;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
//import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {

		//OBJECT TO JSON
//		Field[] dogField = dog.getClass().getDeclaredFields();
//		StringBuilder json = new StringBuilder("{");
//		for(int i = 0; i<dogField.length; i++){
//			json.append(dogField[i].getName()).append(":");
//			dogField[i].setAccessible(true);
//			if(dogField[i].getType().equals(String.class)){
//				json.append("\"").append(dogField[i].get(dog)).append("\",");
//			}
//			if(dogField[i].getType().equals(Long.class)){
//				json.append("\"").append(dogField[i].get(dog)).append("\",");
//			}
//			if(dogField[i].getType().equals(Integer.class)){
//				json.append("\"").append(dogField[i].get(dog)).append("\"}");
//			}
//		}
//		System.out.println(json);

		SpringApplication.run(DemoApplication.class, args);
	}
}


