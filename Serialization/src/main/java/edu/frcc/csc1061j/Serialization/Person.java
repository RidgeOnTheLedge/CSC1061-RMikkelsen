package edu.frcc.csc1061j.Serialization;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "first_name", "last_name" })
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int age;
	private LocalDate dob;
	List<Person> friends = new ArrayList<>();

	public Person()
	{

	}

	public Person(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		// this.dob = null;
	}

	public Person(String firstName, String lastName, int age, LocalDate dob)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.dob = null;
	}

	@JsonProperty("first_name")
	public String getFirstName()
	{
		return firstName;
	}

	@JsonProperty("last_name")
	public String getLastName()
	{
		return lastName;
	}

	public int getAge()
	{
		return age;
	}

	public List<Person> getFriends()
	{
		return friends;
	}

	@Override
	public String toString()
	{
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", dob=" + dob
				+ ", friends=" + friends + "]";
	}

}
