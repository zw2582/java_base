package javabase.lean.classobj.inherits;

public interface InterAnimal {
	
	int interI = 12;

	default void go() {
		System.out.println("i am InterAnimal");
	}
	
	static void interPrint() {
		System.out.println("i am interPrint");
	}
}
