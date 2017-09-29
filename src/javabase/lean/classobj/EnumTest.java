package javabase.lean.classobj;

public class EnumTest {

	Day day;
	
	public EnumTest(Day day) {
		this.day = day;
	}
	
	public void tellItLikeItIs() {
		switch (day) {
		case SUNDAY:
			System.out.println("sunday");
			break;

		default:
			break;
		}
	}
	
	public void tellArray() {
		Day[] days = Day.values();
		for(Day d : days) {
			System.out.println(d);
		}
	}
	
	public static void main(String[] args) {
		new EnumTest(Day.FAIDAY).tellArray();
	}
}
