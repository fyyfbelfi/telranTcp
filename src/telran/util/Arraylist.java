package telran.util;
import java.util.Arrays;

public class Arraylist<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 4;
	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public Arraylist(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public Arraylist() {
		this(DEFAULT_CAPACITY);
	}
	
	
	@Override
	public boolean add(T obj) {
		if(size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;
		return true;
	}
	 private void reallocate() {
		 //try
		 array = Arrays.copyOf(array, array.length * 2);
		 //catch
	 }

	@Override
	public int size() {
		return size;
	}
	@Override
	public void add(int index, T obj) {
		//Insert
		int len = array.length;
		if(index < 0) {
		//throw exception
			return;
		}
		
		if(index >= len) {
		//show window with question : resize of array?
//			if (No)
//				return;
//			else
//				reallocate();
//		
		}
		if(size == array.length) {
			reallocate();
		}
		
		System.arraycopy(array, index, array, index+1, len - index);
		array[index] = obj;
		size++;
		
		print("Insert");
		
		
	}

	@Override
	public T remove(int index) {
		if((index < 0)||(index > array.length)) {
			return null;
		}
		T element = array[index];
		array[index] = null;
		size--;  // ???? 
		return element;
	}

	@Override
	public T get(int index) {
		if((index < 0)||(index > array.length)) {
			return null;
		}
		return array[index];
	}

	private void print(String name)
	{
		System.out.print("\n" + name + "\n");
		for(int i=0; i< array.length; i++)
			System.out.print(array[i]);
	}
}
