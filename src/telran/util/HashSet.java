package telran.util;
//TODO
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class HashSet<T> implements Set<T> {
	private static final int DEFAULT_HASH_TABLE_SIZE = 16;
	private LinkedList<T>[] hashTable;
	private int size;
	private class HashSetIterator implements Iterator<T> {
		Integer currentIteratorIndex;
		Iterator<T> currentIterator;
		Iterator<T> prevIterator;
		boolean flNext = false;
		HashSetIterator() {
			initialState();
		}
		private void initialState() {
			currentIteratorIndex = getCurrentIteratorIndex(-1);
			if(currentIteratorIndex > -1) {
				currentIterator = hashTable[currentIteratorIndex].iterator();
				
				
			}
			
			
		}
		private int getCurrentIteratorIndex(int currentIndex) {
			currentIndex++;
			while(currentIndex < hashTable.length && 
					(hashTable[currentIndex] == null || hashTable[currentIndex].size() == 0)) {
				currentIndex++;
			}
			return currentIndex < hashTable.length ? currentIndex : -1;
		}
		@Override
		public boolean hasNext() {
			
			return currentIteratorIndex >= 0;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T res = currentIterator.next();
			prevIterator = currentIterator;
			updateState();
			flNext = true;
			return res;
		}
		private void updateState() {
			if(!currentIterator.hasNext()) {
				currentIteratorIndex =
						getCurrentIteratorIndex(currentIteratorIndex);
				if(currentIteratorIndex >= 0) {
					currentIterator = hashTable[currentIteratorIndex].iterator();
				}
			}
			
			
		}
		@Override
		public void remove() {
			if(!flNext) {
				throw new IllegalStateException();
			}
			prevIterator.remove();
			size--;
			flNext = false;
		}
		
	}
	@SuppressWarnings("unchecked")
	public HashSet(int hashTableSize) {
		hashTable = new LinkedList[hashTableSize];
	}
	public HashSet() {
		this(DEFAULT_HASH_TABLE_SIZE);
	}
	@Override
	public Iterator<T> iterator() {
		
		return new HashSetIterator();
	}

	@Override
	public boolean add(T obj) {
		boolean res = false;
		if(size >= 0.75 * hashTable.length) {
			recreation();
		}
		int index = getHashTableIndex(obj);
		if(hashTable[index] == null) {
			hashTable[index] = new LinkedList<>();
		}
		if(!hashTable[index].contains(obj)) {
			hashTable[index].add(obj);
			size++;
			res = true;
		}
		
		return res;
	}

	private int getHashTableIndex(T obj) {
		
		return Math.abs(obj.hashCode()) % hashTable.length;
	}
	private void recreation() {
		HashSet<T> tmp = new HashSet<>(hashTable.length * 2);
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (T obj : hashTable[i]) {
					tmp.add(obj);
				} 
			}
		}
		this.hashTable = tmp.hashTable;
		
	}
	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		int index = getHashTableIndex(pattern);
		if (hashTable[index] != null) {
			res = hashTable[index].remove(pattern);
			if (res) {
				size--;
			}
		}
		return res;
	}

	@Override
	public boolean contains(T pattern) {
		int index = getHashTableIndex(pattern);
		return hashTable[index] != null && hashTable[index].contains(pattern);
	}
	@Override
	public T get(T pattern) {
		T res = null;
		int index = getHashTableIndex(pattern);
		if(hashTable[index] != null) {
			List<T> list = hashTable[index];
			Iterator<T> it = list.iterator();
			while(it.hasNext() && res == null) {
				T obj = it.next();
				if (obj.equals(pattern)) {
					res = obj;
				}
			}
		}
		return res;
	}
	@Override
	public T[] toArray(T[] arr) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean removeIf(Predicate<T> predicate) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
