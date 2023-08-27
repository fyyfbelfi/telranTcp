package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Disabled;

import telran.util.*;

abstract class ListTest extends CollectionTest{
//private static final int BIG_LENGTH = 100000;

List<Integer> list = getList();

@Override
protected Collection<Integer> getCollection() {
	return list;
}

	abstract protected <T> List<T> getList() ;
	
	Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
		
	@Disabled
		@Test
		void testAdd_old() {
			assertTrue(list.add(numbers[0]));
			assertEquals(numbers.length + 1, list.size());
					
			Arraylist<String>  strs= new Arraylist<>();  
			strs.add("Hello");
			strs.add("");
			strs.add(" !");
			
			assertEquals(3, strs.size());
		}
		
		@Test
		//@Disabled
		void testGet() {
			assertEquals(-20, list.get(1));
			assertThrowsExactly(IndexOutOfBoundsException.class,
					() ->list.get(-1));
			assertThrowsExactly(IndexOutOfBoundsException.class,
					() ->list.get(list.size()));
			
		/*	Arraylist<String>  strs= new Arraylist<>();
			String s1 = "Hello";
			String s2 = " word";
			String s3 = "!";
			strs.add(s1);
			strs.add(s2);
			strs.add(s3);
			
			assertEquals(s1, strs.get(0));
			assertEquals(s3, strs.get(strs.size()-1));*/
		}
		
		
		@Test
		void testAddIndex() {
			list.add(2, 88);
			assertEquals(7, list.get(3));
			assertEquals(88, list.get(2));
			assertEquals(7, list.size());
			list.add(6, 99);
			assertEquals(99, list.get(6));
			assertThrowsExactly(IndexOutOfBoundsException.class,
					() ->list.add(list.size() + 1, 100));
			assertThrowsExactly(IndexOutOfBoundsException.class,
					() ->list.add(-1, 100));
			
		}
		
		@Test
		void testRemoveIndex() {
			int n = list.size();
			assertThrowsExactly(IndexOutOfBoundsException.class,() ->list.remove(n+1));
			Integer dd = -1;
			list.remove(dd);
			assertEquals(n, list.size());
			
			Integer elem = list.remove(2);
			assertEquals(7, elem);
			assertEquals(n-1, list.size());
			
		}
	//-------------------------------------------------------	
		@Test
		void testIndexOf() {
			list.add(3, 10);
			assertEquals(0, list.indexOf(10));
			assertEquals(-1, list.indexOf((Integer)null));
		}
		
		@Test
		void testLastIndexOf() {
			list.add(2, 100);
			assertEquals(5, list.lastIndexOf(100));
			assertEquals(-1, list.lastIndexOf(6));
		}
		

		
		//-------------------------------------------------------	
		@Test
		void sortComparator() {
			//Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
			Integer[] expected = {-20, 7, 10, 30, 50, 100};
			list.sort();
			assertArrayEquals(expected, list.toArray(new Integer[expected.length]));
			
		/*	Arraylist<Integer> list_sort = new Arraylist<>(10);
			for( int i = 0; i < 10; i++)
				list_sort.add(i+1);
			list_sort.sort();	
			assertEquals(1, list_sort.get(0));*/
			
		}
		
		@Test
		void sortComparable() {
			Integer[] expected = {200, 100, 50, 30 , 10, 7, 2, -20};
			int size = expected.length;
			list.add(3, 200);
			list.add(2);
			
			list.sort(new IntegerComparator(false)); 
			assertArrayEquals(expected, list.toArray(new Integer[size]));
			Integer[] expected1 = {-20, 2, 7,10,30,50,100, 200};
			list.sort(new IntegerComparator(true)); 
			assertArrayEquals(expected1, list.toArray(new Integer[size]));
			
		/*	Arraylist<Integer> list_sort = new Arraylist<>(10);
			for( int i = 0; i < 10; i++)
				list_sort.add(i+1);
			list_sort.sort(new IntegerComparator(false));	
			assertEquals(10, list_sort.get(0));*/
			
			
		}

		@Test
		void sortEventOddComparator() {
			//Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
			Integer[] expected = {-20, 10, 30, 50, 100, 17, 7};
			list.add(17);
			list.sort(new EventOddComparator());
			assertArrayEquals(expected, list.toArray(new Integer[0]));
			
			Arraylist<Integer> list_sort = new Arraylist<>(10);
			for( int i = 0; i < 10; i++)
				list_sort.add(i+1);
			list_sort.sort(new EventOddComparator());	
			assertEquals(2, list_sort.get(0));
			assertEquals(1, list_sort.get(9));
			
		}
		//-------------------------------------------------------------------------
		@Test
		void testIndexOfPredicate()  {
			//Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
			assertEquals(1, list.indexOf(a -> a < 0));
			list.add(-17);
			assertEquals(-1, list.indexOf(a -> a % 2 != 0 && a > 7));
		
		}
		
		@Test
		void testLastIndexOfPredicate()  {
			//Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
			list.add(-17);
			list.add(3, -17);
			
			assertEquals(7, list.lastIndexOf(a -> a == -17));
			
			assertEquals(6, list.lastIndexOf(a -> a % 3 == 0));
			assertEquals(-1, list.lastIndexOf(a -> a  == 0));
		
		}
		
		@Override
		protected Integer[] getActual(Integer[] array, int size) {
			
			return array;
		}
		@Override
		protected Integer[] getExpected(Integer[] array) {
			
			return array;
		}

}
