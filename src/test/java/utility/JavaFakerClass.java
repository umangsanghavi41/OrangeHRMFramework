package utility;

import com.github.javafaker.Faker;

public class JavaFakerClass {
	public static String firstName()
	{
		Faker faker=new Faker();
		String firstName=faker.name().firstName();
		return firstName;
	}
	
	public static String lastName()
	{
		Faker faker=new Faker();
		String lastName=faker.name().lastName();
		return lastName;
	}
}
