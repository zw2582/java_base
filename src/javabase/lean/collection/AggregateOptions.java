package javabase.lean.collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.IntConsumer;

/**
 * 聚合操作
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月25日上午9:40:41
 */
public class AggregateOptions {
	
	public static void main(String[] args) {
		ArrayList<Person> al = new ArrayList<>();
		
		//打印所有女人的名称
		/*al.stream()
			.filter(p->p.gender == Person.Sex.MALE)
			.forEach(e->System.out.println(e.name));*/
		
		//计算女人的年龄平均值
		/*al.stream()
			.filter(e->e.gender == Person.Sex.MALE)
			.mapToInt(Person::getAge)
			.average().getAsDouble();*/
		
		//stream.collect
		ArrayList<Integer> ali = new ArrayList<>(Arrays.asList(1,2,3,4,5));
		Avger collect = ali.stream()
				.collect(Avger::new, Avger::accept, Avger::combine);
		
		//stream.reduce
		Avger a = new Avger();
		ali.stream().reduce(0, a::accepts);
		
		System.out.println(collect.average());
	}
	
	static class Avger {
		private int i = 0;
		private int count = 0;
		
		public Avger() {
			System.out.println("new Avger");
		}
		
		public int accepts(int i, int b) {
			this.i = i + b;
			this.count ++;
			System.out.println("accept:i:"+this.i+",count:"+count);
			return this.i;
		}
		
		public double average() {
	        return count > 0 ? ((double) i)/count : 0;
	    }
		
		public void accept(int i) {
			this.i += i;
			count++;
			System.out.println("accept:i:"+this.i+",count:"+count);
		}
		
		public void combine(Avger other) {
			this.i += other.i;
			this.count += other.count;
			System.out.println("combine:i:"+i+",count:"+count);
		}
	}

	static class Person {

	    public enum Sex {
	        MALE, FEMALE
	    }

	    String name;
	    LocalDate birthday;
	    Sex gender;
	    String emailAddress;
	    public int getAge() {
	    	return 0;
	    }
	    
	    public double getS() {
	    	return 1D;
	    }
	    
	}
}
