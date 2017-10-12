package javabase.lean.classobj.inherits;

public class Cat2 extends AbstractAnimal{

	@Override
	public void dd() {
		
	}
	
	public static void main(String[] args) {
		Cat2.gogo();
		int i = Cat2.interI;
		//接口的静态方法不能被继承，只能在子类中使用
//		Cat2.interPrint();
		InterAnimal.interPrint();
		
		Cat2 cat2 = new Cat2();
		cat2.go();
	}

}
