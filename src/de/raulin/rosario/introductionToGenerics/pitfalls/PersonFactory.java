package de.raulin.rosario.introductionToGenerics.pitfalls;

public final class PersonFactory extends AbstractFactory<Person> {

	@Override
	public Person newInstance() {
		return new Person();
	}

}
