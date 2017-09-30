package javabase.lean.classobj.inherits;

public class Cat extends Animal implements InterAnimal {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }
    public void go() {
		System.out.println("i am Cat");
	}

    public static void main(String[] args) {
    	Animal myCat = new Cat();
        
    	//静态方法隐藏
    	myCat.testClassMethod();
    	//实例方法覆盖
    	myCat.testInstanceMethod();
    	
    	InterAnimal cat = new Cat();
    	cat.go();
    }
}
