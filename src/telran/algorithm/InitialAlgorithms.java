package telran.algorithm;
import java.util.Comparator;



public class InitialAlgorithms {
	public static void sortShortPositive(short [] array) {
		int [] helper = new int[Short.MAX_VALUE];
		for(int i=0; i< array.length; i++) {
			helper[array[i]]++;  //helper[10] = 2 => 10 occurs twice in array
		}
		int  index =0;
		for(int i=0; i< helper.length; i++) {
			for (int j=0; j< helper[i]; j++) {
				array[index++] = (short) i;
			}
		}
	}
	
	public static boolean isSum2(short[] array, short sum) {
		boolean res = false;
		boolean [] helperPlus = new boolean[Short.MAX_VALUE];
		boolean [] helperMinus = new boolean[Short.MAX_VALUE];
		int ind ;
		for(int i=0; i< array.length; i++) {
			int temp = sum - array[i];
			ind = array[i];
			if(array[i] < 0) {
				ind = Math.abs(array[i]);
			}
			if(array[i] < 0 ){
				
				if(helperMinus[ind]) {
					res = true;
					return res;
				}
			}
			else {
				if(helperPlus[ind]) {
					res = true;
					return res;
				}
			}
			
			if(temp < 0) {
				int ind1 = Math.abs(temp);
				helperMinus[ind1] = true;
			}
			else {
				helperPlus[temp] = true;
			}
			
		}
		return res;
	}
	
	// return -1 if there is not numbers<0 not correct, i think returning 0 is better
	public static short getMaxPositiveWithNegativeReflecn(short[] array) { 
		short res = 0;
		
		boolean [] helperPlus = new boolean[Short.MAX_VALUE];
		boolean [] helperMinus = new boolean[Short.MAX_VALUE];
		for(int i=0; i<array.length; i++) {
			if(array[i] > 0) {
				helperPlus[array[i]] = true;
				if(helperMinus[array[i]]) {
					res = array[i] > res ? array[i] : res;
				}
			}
			else {  // <0
				short temp = (short)Math.abs(array[i]);
				helperMinus[temp] = true;
				if(helperPlus[temp]) {
					res = temp > res ? temp : res;
				}
			}
			
		}
		
		res = (short)(res == 0 ? -1 : res);
		return (res);
		
	}
	
	public static void	bubbleSort(short[] array) {
		boolean isContinue = true;
		for(int i= array.length; i >0 && isContinue; --i) {  
			isContinue = false;
			for (int j = 0; j+1 < i; j++) {
				if(array[j] >  array[j+1])
				{
					short temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					isContinue = true;
				}
					
			//		count++; 
			//		print(array, "step ".concat(Integer.toString(count)));	
			}
		}
	}
	
	public static <T> int binarySearch(T [] array, T key,
			Comparator<T> comp) {
		int leftIndex = 0;
		int rightIndex = array.length - 1;
		
		int lim = comp.compare(key, array[0]);
		if( lim <= 0)
			return lim == 0 ? 0 : -1;

		int middleIndex = rightIndex / 2;
		int compRes = 0;
		int res = -1;
		boolean Found = false;
		boolean checkCopy = false;
		while((leftIndex <= rightIndex) && !checkCopy) {
			compRes = comp.compare(key, array[middleIndex] );
			if (compRes == 0) {
				Found = true; 
				res = middleIndex;
			}
			if (compRes > 0) {
				//move to right part of the array
				leftIndex = middleIndex + 1;
				if(Found) { 
					checkCopy = true;
				}
			} else {
				rightIndex = middleIndex - 1;
			}
			middleIndex = (leftIndex + rightIndex) / 2;
			
		}
		
		 res = Found ?  res : (-1-leftIndex);
		System.out.print("\n index " + key + " = " + res  + "\n");
		return res;
	}
	
		
	public static <T> void print(T[]arr, String name)
	{
		System.out.print("\n" + name + "\n");
		for(int i=0; i< arr.length; i++)
			System.out.print(arr[i] + " ");
	}
}
