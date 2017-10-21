package javabase.lean.classobj.generic;

import org.junit.Test;

public class GenericBox <T> {

	private T o;

	public T getO() {
		return o;
	}

	public void setO(T o) {
		this.o = o;
	}
	
	@Test
	public void testBox() {
		GenericBox gb = new GenericBox();
		GenericBox<Integer> bb2 = gb;
		
		GenericBox<Integer> gb2 = new GenericBox<Integer>();
		GenericBox ggb = gb2;
	}
	
}
