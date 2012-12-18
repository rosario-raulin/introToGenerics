package de.raulin.rosario.introductionToGenerics.pitfalls;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class GenericArrays {
	
	// Imagine we want a method to return a generic array...	
	@SuppressWarnings("unchecked")
	public static <T> T[] generateTypedArray(int size) {
		// return new T[size];
		// We would think that this'll work but it doesn't even compile.
		
		return (T[]) new Object[size];
		// Our second idea is to create and Object[] array and cast it.
		// You'd probably say: Well, in the end, it's an Object[] anyway,
		// so why not?		
	}
	
	public static void main(String[] args) {
		
		// final Integer[] x = generateTypedArray(20);
		// ClassCastException: [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
		// WTH?? -- yes, this doesn't work.
		// Arrays need type information at runtime but Object[] isn't Integer[] so we
		// can't do that.
				
		final Integer[] x = generateTypedArray(Integer.class, 20);
		for (int i = 0; i < x.length; ++i) {
			x[i] = new Integer(i);
		}
		System.out.println(Arrays.toString(x));
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] generateTypedArray(final Class<T> clazz, int size) {
		// This is THE ONLY possible way! (using reflections, yet another complicated story... )
		return (T[]) Array.newInstance(clazz, size);
	}	
	
}
