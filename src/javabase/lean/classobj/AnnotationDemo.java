package javabase.lean.classobj;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.reflect.AnnotatedElement;

/**
 * 自定义注解
 * @author wei.w.zhou.integle.com
 * @copyright 2017年9月29日下午4:13:38
 */
public class AnnotationDemo {
	
	/**
	 * 定义自定义注解
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年9月29日下午4:22:27
	 */
	@interface MyAnnotation {
		
		String name() default "caca";
	}
	
	/**
	 * @deprecated 预定义注解，用于弃用某个元素，可以使方法，类，域，与javadoc的@deprecated关联使用可添加注释
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年9月29日下午4:23:09
	 */
	@Deprecated
	public static void testDeprecated() {
		System.out.println("i am deprecated");
	}
	
	//定义可重复注解，step1
	@Repeatable(Schedules.class)
	public @interface Schedule {
	  String dayOfMonth() default "first";
	  String dayOfWeek() default "Mon";
	  int hour() default 12;
	}
	
	//定义可重复注解，step2
	public @interface Schedules {
	    Schedule[] value();
	}
	
	@Schedule
	public class Demo {
		
	}
	
	/**
	 * 取回注解
	 * @author wei.w.zhou.integle.com
	 * @copyright 2017年9月29日下午5:23:12
	 */
	public static void retrieving() {
		Class sc = Demo.class;
		Annotation[] annotations = sc.getAnnotations();
		for(Annotation an : annotations) {
			System.out.println(an.toString());
		}
		System.out.println(sc.getAnnotation(Schedule.class));
//		System.out.println(sc.getAnnotatedInterfaces());
//		System.out.println(sc.getAnnotatedSuperclass());
	}
	
	public static void main(String[] args) {
		retrieving();
	}
}
