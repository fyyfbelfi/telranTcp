package telran.util.test;

//import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

//import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import telran.util.*;

class ArraylistTest {

	@Test
	void testAdd() {
		Arraylist<Integer>  numbers= new Arraylist<>(4);
		int n = 5;
		for( int i=0; i < n; i++) {
			numbers.add(i + 2);
		}
		assertEquals(n, numbers.size());
		
		Arraylist<String>  strs= new Arraylist<>();
		strs.add("Hello");
		strs.add("");
		strs.add(" !");
		
		assertEquals(3, strs.size());
	}
	
	@Test
	//@Disabled
	void testGet() {
		Arraylist<Integer>  numbers= new Arraylist<>();
		int n = 3;
		for( int i=0; i < n; i++) {
			numbers.add(i);
		}
		assertEquals(1, numbers.get(1));
		assertEquals(null, numbers.get(3));
		assertEquals(null, numbers.get(-1));
		
		Arraylist<String>  strs= new Arraylist<>();
		String s1 = "Hello";
		String s2 = " word";
		String s3 = "!";
		strs.add(s1);
		strs.add(s2);
		strs.add(s3);
		
		assertEquals(s1, strs.get(0));
		assertEquals(s3, strs.get(strs.size()-1));
	}
	
	
//	@Test
//	void testAddIndex() {
//		Arraylist<Integer>  numbers= new Arraylist<>(4);
//		int n = 3;
//		for( int i=0; i < n; i++) {
//			numbers.add(i);
//		}
//		Arraylist<Integer> expected1 = new Arraylist<>(4);
//		
//		assertArrayEquals(expected1, numbers);
//		
//		
//	}

}
