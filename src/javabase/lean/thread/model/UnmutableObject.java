package javabase.lean.thread.model;

/**
 * 不可变对象
 * @author zhangjiao
 *
 */
//使方法无法被覆盖
final public class UnmutableObject {
	
	//所有的域都必须是private final
	//且不提供setter方法
	private final String message;
	
	//如果存储可变对象的引用，则不提供修改方法，必要时应该存储该对象的副本
	private final mutableObject mo;

	
	public UnmutableObject(String message, mutableObject mo) {
		this.message = message;
		
		//存储副本
		mutableObject moback = new mutableObject();
		moback.i = mo.i;
		this.mo = moback;
	}
	
	public int getMoValue() {
		return this.mo.i;
	}
	
	public static void main(String[] args) {
		mutableObject mo = new mutableObject();
		UnmutableObject umo = new UnmutableObject("cacac", mo);
		
		mo.i = 5;
		
		System.out.println(umo.getMoValue());
	}
}
