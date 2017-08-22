package javabase.lean.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapDemo {

	public static void main(String[] args) {
		collectionView();
	}
	
	/**
	 * Map的不同实现
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @copyright 2017年8月22日上午9:55:05
	 */
	public static void testTypeMap() {
		String arg = "java freq if it is to be it is up to me to delegate";
		String[] args = arg.split(" ");
		
		//hashMap
		HashMap<String, Integer> hm = new HashMap<>();
		for (String a : args) {
			Integer count = hm.get(a);
			hm.put(a, (count == null) ? 1 : count+1);
		}
		
		System.out.println("*****HashMap******");
		System.out.println(hm);
		
		//treeMap
		TreeMap<String, Integer> tm = new TreeMap<>();
		for (String a : args) {
			Integer count = tm.get(a);
			tm.put(a, (count == null) ? 1 : count+1);
		}
		System.out.println("*****treeMap******");
		System.out.println(tm);
		
		//LinkedHashMap
		LinkedHashMap<String, Integer> lkm = new LinkedHashMap<>();
		for (String a : args) {
			Integer count = lkm.get(a);
			lkm.put(a, (count == null) ? 1 : count+1);
		}
		System.out.println("*****LinkedHashMap******");
		System.out.println(lkm);		
	}
	
	
	/**
	 * 构造初始化数据
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年8月22日上午10:15:39
	 */
	public static void typeConversion() {
		String arg = "java freq if it is to be it is up to me to delegate";
		String[] args = arg.split(" ");
		
		//LinkedHashMap
		Map<String, Integer> hm = new LinkedHashMap<>();
		for (String a : args) {
			Integer count = hm.get(a);
			hm.put(a, (count == null) ? 1 : count+1);
		}
		System.out.println("*****LinkedHashMap******");
		System.out.println(hm);
		
		//HashMap
		Map<String, Integer> tm = new HashMap<>(hm);
		System.out.println("*****HashMap******");
		System.out.println(tm);
		
		//TreeMap
		Map<String, Integer> lkm = new TreeMap<>(tm);
		System.out.println("*****TreeMap******");
		System.out.println(lkm);
	}
	
	public static void collectionView() {
		String arg = "java freq if it is to be it is up to me to delegate";
		String[] args = arg.split(" ");
		
		//LinkedHashMap
		Map<String, Integer> hm = new LinkedHashMap<>();
		for (String a : args) {
			Integer count = hm.get(a);
			hm.put(a, (count == null) ? 1 : count+1);
		}
		
		//Collection views
		System.out.println(hm.keySet());
		System.out.println(hm.values());
		System.out.println(hm.entrySet());
		
		System.out.println("*****测试collection-view删除对backing map的影响");
		System.out.println("原数据：");
		System.out.println(hm);
		
		//Collection-views的修改是否会影响backing Map
		Iterator<String> iterator = hm.keySet().iterator();
		while(iterator.hasNext()) {
			String j = iterator.next();
			if (j.equals("java")) {
				iterator.remove();
			}
		}
		System.out.println("keySet remove:");
		System.out.println(hm);
		
		//values的测试
		for(Iterator<Integer> it = hm.values().iterator();it.hasNext();) {
			Integer j = it.next();
			if (j == 1) {
				it.remove();
			}
		}
		System.out.println("values remove:");
		System.out.println(hm);
		
		//entrySet的测试
		Entry<String, Integer> entry = new MapDemo.MyEntry<>("it", 2);
		for (Iterator<Map.Entry<String, Integer>> it = hm.entrySet().iterator();
				it.hasNext();) {
			Entry<String, Integer> next = it.next();
			if (next.equals(entry)) {
				it.remove();
			}
		}
		
		System.out.println("entrySet remove:");
		System.out.println(hm);
	}
	
	public static void collectionViewOpration() {
		String arg = "java freq if it is to be it is up to me to delegate";
		String[] args = arg.split(" ");
		
		//LinkedHashMap
		Map<String, Integer> hm = new LinkedHashMap<>();
		for (String a : args) {
			Integer count = hm.get(a);
			hm.put(a, (count == null) ? 1 : count+1);
		}
		LinkedHashMap<String, Integer> hm2 = new LinkedHashMap<>(hm);
		
		//判断是否包含另一个map
		System.out.println("Collection-veiw.containAll:判断是否包含另一个map");
		boolean containsAll = hm.entrySet().containsAll(hm2.entrySet());
		System.out.println("containAll:"+containsAll);
	}
	
	static class MyEntry<K, V> implements Map.Entry<K, V> {
		
		private K key;
		
		private V val;
		
		
		
		public MyEntry() {
			super();
		}

		public MyEntry(K key, V val) {
			super();
			this.key = key;
			this.val = val;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return val;
		}

		@Override
		public V setValue(V value) {
			this.val = value;
			return this.val;
		}
		
	}
}
