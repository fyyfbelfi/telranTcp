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
		
		if((index < 0) || (index > size)){
		//throw exception
			return;
		}
			
		if(size >= array.length) {
			reallocate();
		}
		
		System.arraycopy(array, index, array, index+1, size - index);
		array[index] = obj;
		size++;
		
	}

	@Override
	public T remove(int index) {
		if((index < 0)||(index >= size)) {
			return null;
		}
		
		T element = array[index];
		System.arraycopy(array, index+1, array, index, size - index);
		size--;  
		return element;
		
	}

	@Override
	public T get(int index) {
		if((index < 0)||(index > array.length)) {
			return null;
		}
		return array[index];
	}

	private void print(T[]arr, String name)
	{
		System.out.print("\n" + name + "\n");
		for(int i=0; i< arr.length; i++)
			System.out.print(arr[i] + " ");
	}
	@Override
	public boolean remove(T pattern) {
		int index = indexOf(pattern);
		return (remove(index) != null);
	}
	
	@Override
	public T[] toArray(T[] arr) {
		T[] res = arr;
		if(res.length < size)
			res = (T[])Arrays.copyOf(array, size, arr.getClass());
		else {
			System.arraycopy(array, 0, res, 0, size);
//			if(res.length > size)
//				res[size] = null;   // I want fill null all elements after size
		
			for(int i = size; i < res.length; i++) {
				res[i] = null;
			}
		}
		print(res, "toArray");
		return res;
	}
	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while(index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}
	private boolean isEqual(T object, T pattern) {
		
		return pattern == null ? object == pattern :
			pattern.equals(object);
	}
	
	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int index = size;
		while(index >= 0 && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index--;
		}
		return res;
	}
}
