package javabase.lean.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HasChinese {

	/**
	 * 为什么String.matches匹配不到，下面那个函数能够匹配
	 * @author wei.w.zhou.integle.com
	 * @param args
	 * @copyright 2017年8月14日下午5:09:00
	 */
	public static void main(String[] args) {
		String keyword = "主";
		
		boolean matchCnname = false;
		if (keyword.matches("[\u4e00-\u9fa5]")) {
			matchCnname = true;
		}
		
		System.out.println(matchCnname);
		System.out.println(isContainChinese(keyword));
	}
	
	public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
