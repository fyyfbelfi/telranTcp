package telran.algorithm.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import telran.util.Arraylist;
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
		
		print(testArray, "Sum");
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
		print(testArray, "max");
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
}
