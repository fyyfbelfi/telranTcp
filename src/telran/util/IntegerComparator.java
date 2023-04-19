package telran.util;

import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer> {

	public IntegerComparator(boolean isIncrease){
		increase = isIncrease;
	}
	@Override
	public int compare(Integer o1, Integer o2) {
		if (increase)
			return o1.compareTo(o2);
		return o2.compareTo(o1);
	}
	boolean increase = true;

}
