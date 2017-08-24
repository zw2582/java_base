package javabase.lean.interfaces;

public interface DefaultMethod {

	void gogo();
	
	//和gogo()一样
	abstract void caca();
	
	//静态方法
	static void caca1() {
		System.out.println("caca");
	}
	
	//默认方法
	default void caca2() {
		System.out.println("caca2");
	}
}
