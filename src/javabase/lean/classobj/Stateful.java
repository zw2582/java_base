package javabase.lean.classobj;

import java.beans.Customizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class Stateful {

	public static void main(String[] args) {
		Integer[] intArray = {1, 2, 3, 4, 5, 6, 7, 8 };
		List<Integer> listOfIntegers =
		    new ArrayList<>(Arrays.asList(intArray));
		
		List<Integer> serialStorage = new ArrayList<>();
	     
		System.out.println("Serial stream:");
		listOfIntegers
		    .stream()
		    
		    // Don't do this! It uses a stateful lambda expression.
		    .map(e -> { serialStorage.add(e); return e; })
		    
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		     
		serialStorage
		    .stream()
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");

		System.out.println("Parallel stream:");
		/*List<Integer> parallelStorage = Collections.synchronizedList(
		    new ArrayList<>());*/
		List<Integer> parallelStorage = new ArrayList<>();
		//不要再strem操作中使用有状态的lambda表达式
		/*listOfIntegers
		    .parallelStream()
		    
		    // Don't do this! It uses a stateful lambda expression.
		    .map(e -> { parallelStorage.add(e); return e; })
		    
		    .forEachOrdered(e -> System.out.print(e + " "));*/
		System.out.println("");
		
		go(listOfIntegers, e -> { parallelStorage.add(e);});
		
		parallelStorage
		    .stream()
		    .forEachOrdered(e -> System.out.print(e + " "));
		System.out.println("");
		
		System.out.println(parallelStorage);
	}
	
	public static <T> void go(List<T> source, Consumer<T> sumer) {
		for(T i : source) {
			sumer.accept(i);
		}
	}
}
