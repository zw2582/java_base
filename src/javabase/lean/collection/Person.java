package javabase.lean.collection;

public class Person {
	
	public enum Sex {
		male,fmale
	}

	public int id;
	public String name;
	public Sex gender;
	
	public Person(int id, String name, Sex gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}
	
	public Sex getGender() {
		return this.gender;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", gender=" + gender + "]";
	}
	
}
