package telran.util;
//TODO
public class HashMap<K, V> extends AbstractMap<K, V> {
public HashMap () {
	set = new HashSet<>();
}
	

	@Override
	protected Set<K> getKeySet() {
		
		return new HashSet<>();
	}

}
