package javabase.lean.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * List的应用，洗牌
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月21日下午2:38:53
 */
public class Deal {
	
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("请输入拿牌数量，和多少次");
			return;
		}
		
		int numberPerHand = Integer.parseInt(args[0]);
		int hands = Integer.parseInt(args[1]);
		
		//初始化牌面
		String[] hua = {"red","black", "mei", "fang"};
		String[] cardn = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
		
		List<String> deaks = new ArrayList<String>();
		for (String h: hua) {
			for (String cn : cardn) {
				deaks.add(h+":"+cn);
			}
		}
		
		//判断拿牌是否合法
		if (numberPerHand * hands > deaks.size()) {
			System.out.println("牌不够");
			return;
		}
		
		//洗牌-泛型方法
		Collections.shuffle(deaks);
		
		//拿牌
		for (int i = 0; i< hands; i++) {
			System.out.println(handDeal(deaks, numberPerHand));
		}
		
		System.out.println(deaks);
	}
	
	//拿牌
	public static <E> List<E> handDeal(List<E> deaks, int num) {
		int size = deaks.size();
		//从末尾删除元素的性能要比从头部删除高很多
		List<E> sl = deaks.subList(size- num, size);
		
		//subList返回的是原List的一个表现，所以需要构造成真正的ArrayList实现
		List<E> hands = new ArrayList<>(sl);
		
		//拿到牌之后，从原来的list中删除拿到的牌
		sl.clear();
		return hands;
	}

}
