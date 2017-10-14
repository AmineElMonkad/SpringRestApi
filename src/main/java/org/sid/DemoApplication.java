package org.sid;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.sid.dao.ContactRepository;
import org.sid.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
	
	@Autowired
	public ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		contactRepository.save(new Contact("elmonkad", "amine", df.parse("21/09/1995"), "elmonkad.234@gmail.com", 0614, "fdf"));
		contactRepository.save(new Contact("monkad", "med", df.parse("21/09/1995"), "monkad.234@gmail.com", 0615, "fdf"));
		contactRepository.findAll().forEach(c->{
			System.out.println(c.getNom());
		});
	}
}
