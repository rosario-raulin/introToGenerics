package de.raulin.rosario.introductionToGenerics.pitfalls;

public final class NoConstructors {

	// We want to call T's constructor...
	public static <T> T getObject(final Class<T> clazz) {
		// ... but we can't do it that way.
		// return new T();
		// There are 2 possible solutions:
		// (a) Reflections -- but we need a no-argument constructor
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			return null;
		} catch (IllegalAccessException e) {
			return null;
		}
	}
	
	// The second way uses inheritance and the so-called 'Factory pattern'.
	public static <T> T getObject(final AbstractFactory<T> factory) {
		return factory.newInstance();
	}
	
	public static void main(String[] args) {
		final Person x = getObject(Person.class);
		x.setAge(20);
		x.setName("Rosario");
		System.out.println(x);
		
		final Person y = getObject(new PersonFactory());
		y.setAge(20);
		y.setName("Kilian");
		System.out.println(y);
	}
}
