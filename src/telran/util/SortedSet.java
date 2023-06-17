package telran.util;
//TODO
public interface SortedSet<T> extends Set<T> {
	T first();
	T last();
	T ceiling(T key);
	T floor(T key);
}
