package javabase.lean.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Fuxi1 {

	public static void main(String[] args) {
		String regex = "max";
		String input = "max max";
		
		//复习find
		//compile创建pattern
		Pattern c = Pattern.compile(regex);
		//pattern创建Matcher
		Matcher m = c.matcher(input);
		
		//find尝试获得下一个匹配的子序列，如果获取到，则可以通过group，start，end获取更多信息
		while (m.find()) {
			//group:匹配到的自序列
			System.out.println(m.group());
			//start:子序列的开始位置
			System.out.println(m.start());
			//end:子序列的结束位置,其位置都是在字符的间隙之间
			System.out.println(m.end());
		}
		
		//find(index):重置匹配器，从指定的索引位置匹配下一个子序列
		m.find(3);
		System.out.println(m.group());
		System.out.println(m.start());
		System.out.println(m.end());
		
		//lookat:从输入序列的开头匹配
		input = "maxjian";
		m = c.matcher(input);
		boolean lookingAt = m.lookingAt();
		System.out.println("lookingAt:"+lookingAt);
		
		//matches:匹配整个输入序列
		input = "maxdd，max i ddd sa";
		m = c.matcher(input);
		boolean matches = m.matches();
		System.out.println("matches:"+matches);
		
		//replaceAll:替换匹配子序列，并返回
		String replace = "ggg";
		String ra = m.replaceAll(replace);
		System.out.println("old:"+input);
		System.out.println("replaceAll:"+ra);
		
		//replaceFirst:替换匹配到的第一个子序列
		String rf = m.replaceFirst(replace);
		System.out.println("old:"+input);
		System.out.println("replaceAll:"+rf);
		
		//appendReplacement:将匹配到的子序列追加到stringBuffer中
		StringBuffer sb = new StringBuffer("i am sb,");
		//reset:重置matcher
		m.reset();
		while (m.find()) {
			m.appendReplacement(sb, replace);
		}
		System.out.println("old:"+input);
		System.out.println("appendReplacement:"+sb.toString());
		//appendTail：追加appendReplacement不匹配的后面部分
		m.appendTail(sb);
		System.out.println("appendTail"+sb.toString());
		
	}
}
