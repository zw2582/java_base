package javabase.lean.io;

import java.io.Console;
import java.util.Arrays;

/**
 * 用console作为控制台输入
 * @author zhangjiao
 *
 */
public class ConsoleInput {

	public static void main(String[] args) {
		Console console = System.console();
		if (console == null) {
			System.out.println("system not support console");
			System.exit(1);
		}
		
		String login = console.readLine("enter your login");
		char[] oldpassword = console.readPassword("enter old password");
		
		if (verify(login, oldpassword)) {
			boolean nomatch;
			do {
				char[] pwd1 = console.readPassword("enter your new password");
				char[] pwd2 = console.readPassword("repeat your password");
				
				nomatch = !Arrays.equals(pwd1, pwd2);
				
				if (nomatch) {
					console.printf("password do not match, enter agin");
				} else  {
					changePassword(login, pwd1);
					console.printf("password for %s is changed", login);
				}
				Arrays.fill(pwd1, ' ');
				Arrays.fill(pwd2, ' ');
			} while (nomatch);
		}
		Arrays.fill(oldpassword, ' ');
	}
	
	public static boolean verify(String login, char[] password) {
		return true;
	}
	
	public static void changePassword(String login, char[] newPassword){
		
	}
}
