package telran.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedHashSet<T> implements Set<T> {
    int size;
    private static class Node<T> {
    	T obj;
    	Node<T> prev;
    	Node<T> next;
    	Node(T obj) {
    		this.obj = obj;
    	}
    }
    Node<T> head;
    Node<T> tail;
    HashMap<T, Node<T>> map = new HashMap<>();
    private class LinkedHashSetIterator implements Iterator<T> {
    //	Node<T> current = ;
    	
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;//current != null;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			return null;
		}
		@Override
		public void remove() {
			//TODO
		}
    	
    }
	@Override
	public boolean add(T obj) {
		boolean res = false;
		if (!map.containsKey(obj)) {
			res = true;
			Node<T> node = new Node<>(obj);
			map.put(obj, node);
			addNode(node);
			size++;
		}
		return res;
	}

	private void addNode(Node<T> node) {
		if(head == null) {
			head = tail = node;
		}
		else {
			node.prev = tail;
			tail.next = node;
			tail = node;
		}
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean remove(T pattern) {
		boolean res = false;
		Node<T> node = map.get(pattern);
		if(node != null) {
			res = true;
			removeNode(node);
			map.remove(pattern);
			size--;
		}
		return res;
	}

	private void removeNode(Node<T> node) {
		// TODO Auto-generated method stub
		if(node == head) {
			head = node.next;
			head.prev = null;
			
		}
		else if (node == tail)
		{
			tail = node.prev;
			tail.next = null;
			
		}
		else {
		
		Node<T> nodeBefore = node.prev;
		Node<T> nodeAfter = node.next;
		nodeBefore.next = nodeAfter;
		nodeAfter.prev = nodeBefore;
		
		
		}
		node.prev = node.next = null;
			
	}

	@Override
	public boolean contains(T pattern) {
		
		return map.containsKey(pattern);
	}

	@Override
	public Iterator<T> iterator() {
		
		return new LinkedHashSetIterator();
	}

	@Override
	public T get(T pattern) {
		Node<T> resNode = map.get(pattern);
		return resNode != null ? resNode.obj : null;
	}

}