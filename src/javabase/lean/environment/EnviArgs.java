package javabase.lean.environment;

import java.util.Map;

/**
 * 系统环境变量
 * @author wei.w.zhou.integle.com
 * @copyright 2017年8月4日下午5:30:33
 */
public class EnviArgs {

	public static void main(String[] args) {
		Map<String, String> envargs = System.getenv();
		
		for(String key :envargs.keySet()) {
			System.out.println(key+":"+envargs.get(key));
		}
	}
}
