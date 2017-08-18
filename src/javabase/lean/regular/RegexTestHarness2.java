package javabase.lean.regular;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegexTestHarness2 {

	/**
	 * 测试错误捕获
	 * 
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @copyright 2017年8月14日下午8:27:30
	 */
	public static void main(String[] args) {
		String regex = "abcd?)";
		
		try {
			Pattern compile = Pattern.compile(regex);
		} catch (PatternSyntaxException e) {
			System.out.println("this is a error:");
			
			System.out.println("description:"+e.getDescription());
			
			System.out.println("index:"+e.getIndex());
			
			System.out.println("pattern:"+e.getPattern());
			
			System.out.println("message:"+e.getMessage());
		}
		
	}
}
