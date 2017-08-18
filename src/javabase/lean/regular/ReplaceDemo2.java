package javabase.lean.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReplaceDemo2 {

	public static void main(String[] args) {
		String input = "abfoodoo";
		String regex = "a*b";
		String replace = "-";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		String re = matcher.replaceFirst("-");
		String ra = matcher.replaceAll("-");
		System.out.println(input);
		System.out.println(re);
		System.out.println(ra);
		
		//String的类似操作
		input.replaceAll(regex, replace);
		input.replaceFirst(regex, replace);
	}
}
