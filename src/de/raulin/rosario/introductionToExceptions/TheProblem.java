package de.raulin.rosario.introductionToExceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class TheProblem {

	public static int fac(final int n) {
		// Precondition: n >= 0!
		// What do we do if the user enter n < 0?
		// We could return a special value to signal this.
		if (n < 0) {
			return -1;
		}
		
		int i = n;
		int x = 1;
		while (i > 0) {
			x = x * i;
			i = i - 1;
		}
		return x;
	}
	
	public static Iterable<Integer> facList(final Iterable<Integer> inp) {
		final List<Integer> facs = new ArrayList<Integer>();
		for (Integer x : inp) {
			int f = fac(x);
			if (f != -1) {
				// What if this case was more serious and we couldn't solve it?
				// Then we would have to return a special value as well...
				// return null;
				facs.add(f);
			}
		}
		return facs;
	}
	
	public static void main(String[] args) {
		final List<Integer> inp = Arrays.asList(0, 1, 2, 3, -24);
		
		for (Integer x : facList(inp)) {
			System.out.println(x);
		}
	}

}
