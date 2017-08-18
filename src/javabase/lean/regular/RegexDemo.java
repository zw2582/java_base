package javabase.lean.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	/**
	 * appendReplacement:追加匹配和替换的部分
	 * appendTail:将appendReplacement剩余部分追加到sb
	 * 
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @copyright 2017年8月14日下午8:14:37
	 */
	public static void main(String[] args) {
		String input = "abfoodoo";
		String regex = "ab";
		String replace = "-";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		
		StringBuffer sb = new StringBuffer();
		
		int i = 0;
		while (matcher.find()) {
			if (i++ < 2) {
				
			}
			matcher.appendReplacement(sb, replace);
		}
		
		System.out.println(sb.toString());
		
		StringBuffer at = matcher.appendTail(sb);
		
		System.out.println(at.toString());
		
	}
}
