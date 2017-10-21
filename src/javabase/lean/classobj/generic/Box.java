package javabase.lean.classobj.generic;

import org.junit.Test;

/**
 * 泛型
 * @author Administrator
 *
 */
public class Box {

	private Object o;

	public Object getO() {
		return o;
	}

	public void setO(Object o) {
		this.o = o;
	}
	
	@Test
	public void testBox() {
		Box box = new Box();
		box.setO(13);
		
		int i = (int) box.getO();
		System.out.println(i);
	}
}
