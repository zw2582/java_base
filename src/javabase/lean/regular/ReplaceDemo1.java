package javabase.lean.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceDemo1 {

	/**
	 * replaceFirst()和replaceAll()
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @copyright 2017年8月14日下午7:44:46
	 */
	public static void main(String[] args) {
		String input = "the dog says meow, all dog says meow";
		String regex = "dog";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		String re = matcher.replaceFirst("cat");
		
		System.out.println(re);
	}
}
