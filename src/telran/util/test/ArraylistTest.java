package telran.util.test;


import telran.util.*;

class ArraylistTest  extends ListTest{

	@Override
	protected <T> List<T> getList() {
		return new Arraylist<>();
	}
	@Override
	protected Integer[] getActual(Integer[] array, int size) {
		
		return array;
	}
	@Override
	protected Integer[] getExpected(Integer[] array) {
		
		return array;
	}
}
