package javabase.lean.classobj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;

/**
 * http://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月23日下午1:55:52
 */
public class LambdaDemo {

	public static void main(String[] args) {
//		aggreagateWithLambda();
		
		/*String[] as = {"a", "b", "c"};
		testLambda(Arrays.asList(as), e->e+"i");*/
		
		//使用自定义功能接口
//		useMyFunction(1, (Integer e)->{return e+7;});
		
		new Thread(()->System.out.print("ca")).start();
	}
	
	/**
	 * 简单使用标准的功能接口
	 */
	public static <T,R> void testLambda(Iterable<T> i, Function<T, R> mapper) {
		for (T ii : i) {
			System.out.println(mapper.apply(ii));
		}
	}
	
	/**
	 * 聚合操作和lambda
	 */
	public static void aggreagateWithLambda() {
		ArrayList<Integer> al = new ArrayList<>(Arrays.asList(1,2,3,4));
		
		al.stream().filter(p->p>1&&p<4)
			.map(e->e+5)
			.forEach(e->System.out.print(e+","));
	}
	
	/**
	 * 自定义功能接口
	 */
	static interface myFunction<R,T> {
		T go(R r);
	}
	
	/**
	 * 使用自定义功能接口
	 */
	public static <R,T> T useMyFunction(R r, myFunction<R, T> mapper) {
		return mapper.go(r);
	}
}
