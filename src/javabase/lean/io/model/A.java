package javabase.lean.io.model;

import java.io.Serializable;

public class A implements Serializable{

	private Integer id;
	
	private String name;
	
	private B b;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}
	
	
}
