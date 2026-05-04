package edu.frcc.csc1061j.Serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class App
{
	public static void main(String[] args)
	{

		Person person = new Person("Bob", "Cob", 23, LocalDate.of(2002, Month.APRIL, 21));
		System.out.println(person);

		String filename = "test.txt";
		FileOutputStream fileOut = null;
		ObjectOutputStream objOut = null;

		try
		{
			fileOut = new FileOutputStream(filename);
			objOut = new ObjectOutputStream(fileOut);
			objOut.writeObject(person);
			objOut.close();
			fileOut.close();
		} catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		List<Person> friends = new ArrayList<>();

		// DeSer
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;

		try
		{
			fileIn = new FileInputStream(filename);
			objIn = new ObjectInputStream(fileIn);

			Person per = (Person) objIn.readObject();
			System.out.println("Deserialized object: " + per);

			objIn.close();
			fileIn.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		// Json Serialization

		person.friends.add(new Person("Mary", "Mart", 18, LocalDate.of(2007, Month.APRIL, 3)));
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT)
				.registerModule(new JavaTimeModule());

		try
		{
			String json = mapper.writeValueAsString(person);
			System.out.println(json);
		} catch (JsonProcessingException e)
		{
			e.printStackTrace();
		}

		// Deserialization
		String json = "{" + "\"first_name\" : \"Chad\"," + "\"last_name\" : \"Helmsworth\"," + "\"age\" : 25" + "}";
		try
		{
			Person chad = mapper.readValue(json, Person.class);
			System.out.println(chad);
		} catch (JsonProcessingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
