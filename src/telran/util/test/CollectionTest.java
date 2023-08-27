package telran.util.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.Collection;

public abstract class CollectionTest {

	protected Integer[] numbers = {10, -20, 7, 50, 100, 30};
	protected Collection<Integer> collection;
	@BeforeEach
	void setUp() {
		collection = getCollection();
		for( int i = 0; i < numbers.length; i++) {
			collection.add(numbers[i]);
		}
	}
	abstract protected Collection<Integer> getCollection() ;
	
	@Test
	void testAdd() {
		assertTrue(collection.add(numbers[0]));
		assertEquals(numbers.length + 1, collection.size());
	}
	
	@Test
	void testRemove() {
		Integer a = 100;
		assertTrue( collection.remove(a));
		a = 66;
		assertFalse( collection.remove(a));
		assertFalse( collection.remove(null));
	}
	
	@Test
	void toArray() {
		Integer [] arr = new Integer[collection.size()];
		assertArrayEquals(numbers, collection.toArray(arr));
		Integer [] arr_less = new Integer[collection.size()-1];
		assertArrayEquals(numbers, collection.toArray(arr_less));
		
		Integer [] arr_big = {10, -20, 7, 50, 100, 30, 333, 333, 333, 333};
		Integer []res = collection.toArray(arr_big);
		assertEquals(null, res[collection.size()]);
		
	
	}
	
	@Test
	void testRemoveIfPredicte() {
		//Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
		collection.add(-17);
		
		assertTrue(collection.removeIf(a -> a < 0));
		assertEquals(5, collection.size());
		assertFalse(collection.removeIf(a -> a == 18));
	}
	protected abstract Integer[] getActual(Integer[] actual, int size);
	protected abstract Integer[] getExpected(Integer[] expected);
	
}
