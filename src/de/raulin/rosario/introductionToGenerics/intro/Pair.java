package de.raulin.rosario.introductionToGenerics.intro;

public final class Pair<T1, T2> {
	private final T1 first;
	private final T2 second;
	
	public Pair(final T1 first, final T2 second) {
		this.first = first;
		this.second = second;
	}
	
	public T1 getFrist() {
		return first;
	}
	
	public T2 getSecond() {
		return second;
	}
	
//	public int compareTo(final Pair<T1, T2> other) {
//		return other.getSecond().compareTo(second);
//	}
	
	@Override
	public String toString() {
		return String.format("[%s, %s]", first, second);
	}
	
	public static void main(String[] args) {
		final Pair<String, Integer> p1 = new Pair<String, Integer>("Kilian", 20);
		final Pair<String, Integer> p2 = new Pair<String, Integer>("Rosario", 20);
		
		System.out.println(p1);
		System.out.println(p2);
		// System.out.println(p1.compareTo(p2));
	}
}
