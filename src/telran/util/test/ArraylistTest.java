package telran.util.test;


import telran.util.*;

class ArraylistTest  extends ListTest{

	@Override
	protected <T> List<T> getList() {
		return new Arraylist<>();
	}

}
