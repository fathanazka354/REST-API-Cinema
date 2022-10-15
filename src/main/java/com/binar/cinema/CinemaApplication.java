package com.binar.cinema;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class CinemaApplication{

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
//	@Override
//	public void run(String... args) throws Exception {
//
//		Customer[] customer = new Customer[] {
//				new Customer(
//						"fathan","Azka","0828913","gegersapi","fathan@gamil.com","pass",false,123,90,
//				),
//		};
//
//		for (int i = 0; i < students.length; i++) {
//			studentRepository.save(students[i]);
//		}
//
//		Course[] courses = new Course[] {
//				new Course("Charms", "CH104", "In this class, you will learn spells concerned with giving an object new and unexpected properties."),
//				new Course("Defence Against the Dark Arts", "DADA", "In this class, you will learn defensive techniques against the dark arts."),
//				new Course("Herbology", "HB311", "In this class, you will learn the study of magical plants and how to take care of, utilise and combat them."),
//				new Course("History of Magic", "HIS393", "In this class, you will learn about significant events in wizarding history."),
//				new Course("Potions", "POT102", "In this class, you will learn correct mixing and stirring of ingredients to create mixtures with magical effects."),
//				new Course("Transfiguration", "TR442", "In this class, you will learn the art of changing the form or appearance of an object.")
//		};
//
//		for (int i = 0; i < courses.length; i++) {
//			courseRepository.save(courses[i]);
//		}
//
//	}
}
