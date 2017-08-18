package javabase.lean.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式
 * 简单应用
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月12日下午3:40:05
 */
public class TestHarness1 {
	
	public static void main(String[] args) {
//		String quote = Pattern.quote("hello123\n world");
//		System.out.println(quote);
		
		test1();
		
	}

	/**
	 * 小试牛刀
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @copyright 2017年8月12日下午6:00:49
	 */
	public static void test1() {
		String regex = "o";
		String input = "hello world";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		System.out.println(matcher.lookingAt());
		while (matcher.find()) {
			System.out.format("I found the text" +
                    " \"%s\" starting at " +
                    "index %d and ending at index %d.%n",
                    matcher.group(),
                    matcher.start(),
                    matcher.end());
		}
	}
}
