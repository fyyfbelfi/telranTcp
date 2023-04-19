package telran.util;
import java.util.Comparator;

public class EventOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		boolean odd1 = (((int)o1) & 1) == 0;
		boolean odd2 = (((int)o2) & 1) == 0;
		if( odd1 == odd2) {
		  return odd1 ? o1.compareTo(o2) : o2.compareTo(o1);
		}
		return odd1 ? -1 : 1;
		
	
	}

}
