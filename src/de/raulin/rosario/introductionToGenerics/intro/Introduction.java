package de.raulin.rosario.introductionToGenerics.intro;

import java.util.ArrayList;
import java.util.List;

public final class Introduction {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void oldVersion() {
		// Okay, here's the problem: We want to safe a List of Integers.
		final List elements = new ArrayList();

		elements.add(new Integer(3));
		elements.add(new Integer(5));
		// Accidentally, we add a string here!
		elements.add(new String("foobar"));

		// later in the code...

		Integer sum = new Integer(0);
		for (int i = 0; i < elements.size(); ++i) {
			// List.get() returns an Object, so we need an explicit cast
			// We don't know that someone pushed in a String here!
			// As a result, we get a ClassCastException at runtime!
			sum += (Integer) elements.get(i);
		}
		System.out.println(sum);
	}
	
	public static void usingGenerics() {
		// Let's try this again with Generics (available since Java 5)...
		final List<Integer> elements = new ArrayList<Integer>();

		elements.add(new Integer(3));
		elements.add(new Integer(5));
		// Now, we can't add a string here! It's a compile-time error.
		// elements.add(new String("foobar"));

		// later in the code...

		Integer sum = new Integer(0);
		for (int i = 0; i < elements.size(); ++i) {
			// Now we can be sure that List.get() returns Integers
			// and we don't even need the cast.
			sum += elements.get(i);
		}
		System.out.println(sum);		
	}

	public static void main(String[] args) {
		// oldVersion();
		usingGenerics();
	}

}
