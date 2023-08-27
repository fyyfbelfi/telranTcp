package telran.algorithm.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static telran.algorithm.InitialAlgorithms.*;



class InitialAlgorithmsTest {
	short [] testBigArray; 
	
	@Test
	void testSortShortPositive() {
		short [] testArray= {12, 45, 2, 77, 43, 88};
		short[] expected = {2, 12, 43, 45, 77, 88};
		sortShortPositive(testArray);
		assertArrayEquals(expected, testArray);
		assertEquals(testArray[0],2);
	}
	
	@Test
	void testIsSum2() {
		short [] testArray= {1, 4, -2, 8, 3, 9};
				
	//	print(testArray, "Sum");
		assertTrue(isSum2(testArray,(short) 12));
		assertTrue(isSum2(testArray,(short) 6));
		assertTrue(isSum2(testArray,(short) -1));
		assertTrue(isSum2(testArray,(short) 2));
		assertFalse(isSum2(testArray,(short) 15));
	}

	@Test
	void testGetMaxPositiveWithNegativeReflecn() {
		short [] testArray = new short[10];
		for(int i=0; i<10; i++) {
			testArray[i] = (short) (5 -i);
		}
	//	print(testArray, "max");
		assertEquals(4, getMaxPositiveWithNegativeReflecn(testArray));
		for(int i=0; i<10; i++) {
			testArray[i] = (short) i;
		}
		assertEquals(-1,getMaxPositiveWithNegativeReflecn(testArray));
		
	}
	
	void setUpBig(int num) {
		testBigArray = new short[num];
		for (int i=0; i< testBigArray.length; i++) {
			testBigArray[i] = (short)(Math.random() * Short.MAX_VALUE );
		}
	}
	private void runTest() {
		for(int i = 1; i < testBigArray.length; i++) {
			assertTrue(testBigArray[i - 1] <= testBigArray[i]);
		}
	}
	private static final long MGB = 1024 * 1024;
	private void displayMemoryMap(Runtime runtime) {
		System.out.printf("free memory: %dM, total memory: %dM, maximal memory:"
				+ " %dM\n",
				runtime.freeMemory() / MGB, runtime.totalMemory() / MGB,
				runtime.maxMemory() / MGB);
		
	}
	
	@Test
	void testMemory() {
		Runtime runtime = Runtime.getRuntime();
		displayMemoryMap(runtime);
	}
	
	@Test
	void testSortShortPositive_Big() {
		setUpBig(10000);
		sortShortPositive(testBigArray);
		runTest();
		
	}
	@Test
	void testBubbleSorte_Big() {
		setUpBig(10000);
		bubbleSort(testBigArray);
		runTest();
		
	}
	
	@Test
	void testBinarySearch() {
		Short [] testArray = new Short[22];
		for(int i=0; i<20; i++) {
			if(i >=10 && i< 15)
				testArray[i] = 21;
			else	
			  testArray[i] = (short)(i*2);
			
		}
		testArray[20] = 38;
		testArray[21] = 38;
		print(testArray, "bin");
		int res =binarySearch(testArray, 1,  (a,b )->  a.shortValue() - b.shortValue() );
		assertEquals(-2, res);
		res =binarySearch(testArray, 12,  (a,b )->  a.shortValue() - b.shortValue() );
		assertEquals(6, res);
		res =binarySearch(testArray, 40,  (a,b )->  a.shortValue() - b.shortValue() );
		assertEquals(-23, res);
		res =binarySearch(testArray, 38,  (a,b )->  a.shortValue() - b.shortValue() );
		assertEquals(19, res);
		res =binarySearch(testArray, 0,  (a,b )->  a.shortValue() - b.shortValue() );
		assertEquals(0, res);
		res =binarySearch(testArray, 7,  (a,b )->  a.shortValue() - b.shortValue() );
		assertEquals(-5, res);
		res =binarySearch(testArray, 21,  (a,b )->  a.shortValue() - b.shortValue() );
		assertEquals(10, res);
	}
}
