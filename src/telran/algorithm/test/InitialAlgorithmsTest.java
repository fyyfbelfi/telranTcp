package telran.algorithm.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.algorithm.InitialAlgorithms;

//import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.BeforeEach;
//import static telran.algorithm.InitialAlgorithms.*;


class InitialAlgorithmsTest {
	short [] testArray = new short[10];
	@BeforeEach
	void setUp() {
		
	}
	
	@Test
	void testSortShortPositive() {
		short [] testArray= {12, 45, 2, 77, 43, 88};
		short[] expected = {2, 12, 43, 45, 77, 88};
	//	short[] bed = {2, 12, 40, 45, 77, 88};
		InitialAlgorithms.sortShortPositive(testArray);
		InitialAlgorithms.print(testArray, "afterSort");
		assertArrayEquals(expected, testArray);
		assertEquals(testArray[0],2);
	//	assertArrayEquals(bed, testArray);
	
	}
	
	@Test
	void testIsSum2() {
		short [] testArray= {1, 4, -2, 8, 3, 9};
		
		InitialAlgorithms.print(testArray, "Sum");
		assertTrue(InitialAlgorithms.isSum2(testArray,(short) 12));
		assertTrue(InitialAlgorithms.isSum2(testArray,(short) 6));
		assertTrue(InitialAlgorithms.isSum2(testArray,(short) -1));
		assertTrue(InitialAlgorithms.isSum2(testArray,(short) 2));
		assertFalse(InitialAlgorithms.isSum2(testArray,(short) 15));
	}

	@Test
	void testGetMaxPositiveWithNegativeReflecn() {
		for(int i=0; i<10; i++) {
			testArray[i] = (short) ((i%2 == 0) ? i : -i);
		}
		InitialAlgorithms.print(testArray, "Max1");
		assertEquals(9, InitialAlgorithms.getMaxPositiveWithNegativeReflecn(testArray));
		for(int i=0; i<10; i++) {
			testArray[i] = (short) i;
		}
		InitialAlgorithms.print(testArray, "Max2");
		assertEquals(-1,InitialAlgorithms.getMaxPositiveWithNegativeReflecn(testArray));
		
	}
}
