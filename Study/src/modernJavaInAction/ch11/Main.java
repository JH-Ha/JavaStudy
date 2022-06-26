package modernJavaInAction.ch11;

import java.util.Optional;

public class Main {
	public static void main(String[] args) {
		Person person = new Person();

		// Car car = new Car();
		// Insurance insurance = new Insurance();
		Optional<Person> optPerson = Optional.ofNullable(person);
		String name = optPerson.flatMap(Person::getCar).flatMap(Car::getInsurance).map(Insurance::getName)
				.orElse("Unknown");
		System.out.println(name);
	}
}
