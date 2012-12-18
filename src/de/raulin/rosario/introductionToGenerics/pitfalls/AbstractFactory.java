package de.raulin.rosario.introductionToGenerics.pitfalls;

public abstract class AbstractFactory<T> {
	public abstract T newInstance();
}
