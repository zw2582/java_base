package javabase.lean.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 写出一个人的第一个名字与第二个名字相同的正则表达式
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月14日下午8:49:00
 */
public class Question {

	public static void main(String[] args) {
		String regex = "([a-z]+)\\.\\1";
		
		String input ="wei.wei";
		
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		
		while(m.find()) {
			System.out.println(m.group());
		}
		
		System.out.println(m.matches());
	}
}
