package javabase.lean.classobj.inherits;

public class Animal {
	
//	public Animal() {
//		System.out.println("i am super class");
//	}
	
	public Animal(int age) {
		System.out.println("i am super class age:"+age);
	}
	private String a = "a";
	public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Animal");
    }
}
