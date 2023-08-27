package telran.util.test;


import telran.util.*;


class ArraylistTest {
	List<Integer> list;
	Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
	@BeforeEach
	void setUp() {
		list = new Arraylist<>(1);
		for( int i = 0; i < initNumbers.length; i++) {
			list.add(initNumbers[i]);
		}
	}
	
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
	
	
	@Test
	void testAddIndex() {
		Arraylist<Integer>  numbers= new Arraylist<>();
		int n = 5;
		for( int i=0; i < n; i++) {
			numbers.add(i);
		}
		numbers.add(2, 88);
		assertEquals(2, numbers.get(3));
		assertEquals(88, numbers.get(2));
		assertEquals(6, numbers.size());
		numbers.add(6, 99);
		assertEquals(99, numbers.get(6));
		
	}
	
	@Test
	void testRemoveIndex() {
		Arraylist<Integer>  numbers= new Arraylist<>();
		int n = 6;
		for( int i=0; i < n; i++) {
			numbers.add(i);
		}
		numbers.remove(n+1);
		assertEquals(n, numbers.size());
		numbers.remove(-1);
		assertEquals(n, numbers.size());
		
		Integer elem = numbers.remove(2);
		assertEquals(2, elem);
		assertEquals(n-1, numbers.size());
		
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
	
=======
class ArraylistTest  extends ListTest{


	@Override
	protected <T> List<T> getList() {
		return new Arraylist<>();
	}
	@Override
	protected Integer[] getActual(Integer[] array, int size) {
		

		Arraylist<Integer> list_sort = new Arraylist<>(10);
		for( int i = 0; i < 10; i++)
			list_sort.add(i+1);
		list_sort.sort();	
		assertEquals(1, list_sort.get(0));
		
	}
	
	
	@Test
	void sortComparable() {
		Integer[] expected = {200, 100, 50, 30 , 10, 7, 2, -20};
		list.add(3, 200);
		list.add(2);
		
		list.sort(new IntegerComparator(false)); 
		assertArrayEquals(expected, list.toArray(new Integer[0]));
		
		Arraylist<Integer> list_sort = new Arraylist<>(10);
		for( int i = 0; i < 10; i++)
			list_sort.add(i+1);
		list_sort.sort(new IntegerComparator(false));	
		assertEquals(10, list_sort.get(0));
=======
		return array;

	}
	@Override
	protected Integer[] getExpected(Integer[] array) {
		
		return array;
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
	
	@Test
	void testRemoveIfAll() {
		//Integer[] initNumbers = {10, -20, 7, 50, 100, 30};
		list.add(-17);
		list.add(3, -17);
		assertTrue(list.removeIf(a -> a < 0));
		assertEquals(5, list.size());
		assertFalse(list.removeIf(a -> a == 18));
	}
}
