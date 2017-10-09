package javabase.lean.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.BaseStream;
import java.util.stream.Collector.Characteristics;
import java.util.stream.Collectors;

import javabase.lean.collection.Person.Sex;

public class ParalleDemo {

	public static void main(String[] args) {
		ArrayList<Person> al = new ArrayList<>();
		al.add(new Person(1, "zhangsan", Person.Sex.male));
		al.add(new Person(2, "lisi", Person.Sex.male));
		al.add(new Person(3, "wangwu", Person.Sex.fmale));
		al.add(new Person(4, "qiujun", Person.Sex.male));
		al.add(new Person(5, "dabo", Person.Sex.fmale));
		
		
		
		Set<Characteristics> characteristics = Collectors.groupingByConcurrent(Person::getGender).characteristics();
		System.out.println(characteristics);
		
		ConcurrentMap<Sex, List<Person>> map = al.stream().collect(Collectors.groupingByConcurrent(Person::getGender));
		System.out.println(map);
		
		Map<Sex, List<Person>> normap = al.stream().collect(Collectors.groupingBy(Person::getGender));
		System.out.println(normap);
		
		al.parallelStream().unordered();
		
		
	}
}
