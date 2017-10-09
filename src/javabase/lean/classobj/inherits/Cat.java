package javabase.lean.classobj.inherits;

public class Cat extends Animal implements InterAnimal {
	
	public Cat(int age, int i) {
		super(age);
		System.out.println("i am sub class and age:"+age+",i:"+i);
	}
//    public static void testClassMethod() {
//        System.out.println("The static method in Cat");
//    }
    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }
//    public void go() {
//		System.out.println("i am Cat");
//	}

    public static void main(String[] args) {
    	Cat myCat = new Cat(23, 2);
        
    	//静态方法隐藏
    	myCat.testClassMethod();
    	//实例方法覆盖
    	myCat.testInstanceMethod();
    	
    	Cat.testClassMethod();
    	InterAnimal.interPrint();
    	
    	//接口可以继承域，抽象方法，默认方法,不能继承静态方法
    	//类可以继承所有的域，不能继承构造函数
    	//但子类必须在构造函数中的第一行调用一个父类的构造函数，默认情况下会调用无参构造函数
    	System.out.println(Cat.interI);
    	myCat.go();
    	//Cat.interPrint();
    	
    	//InterAnimal cat = new Cat();
    	//cat.go();
    }
}
