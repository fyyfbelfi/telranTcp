package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.LinkedHashSet;
import telran.util.Set;

public class LinkedHashSetTest extends SetTest {

	@Override
	protected <T> Set<T> getSet() {
		
		return new LinkedHashSet<>();
	}
	@Override
	protected Integer[] getExpected(Integer[] expected) {
		return expected;
	}
	@Override 
	protected Integer[] getActual(Integer[] actual, int size) {
		return actual;
	}

}