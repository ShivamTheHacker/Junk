import java.util.Calendar;
import java.util.Scanner;

public class ContactList {

	// int is a number.
	// String is a word or sentence.
	// putting a [] next to int or string turns them into an array
	// arrays hold multiple pieces of data.
	// if your array needs to have both int and string, then make object array
	// object arrays are arrays like Object[].

	private String[] name = new String[2];
	private Object[] birthday = new Object[3];
	private String age;
	private String hobby;
	private String food;
	private String color;
	private String animal;
	private int[] height = new int[2];
	private int weight;
	private String book;
	private String subject;

	public static void main(String[] args) {
		new ContactList().startHere();
	}

	private void startHere() {
		getInfo();
		printInfo();
	}

	private void getInfo() {
		Scanner scan = new Scanner(System.in);

		// Name
		System.out.print("First Name please: ");
		String firstName = scan.next();
		System.out.print("Last Name please: ");
		String lastName = scan.next();
		name[0] = firstName;
		name[1] = lastName;

		// Birthday
		System.out.print("Day of birth: ");
		int day = scan.nextInt();
		System.out.print("Month of birth: ");
		int month = scan.nextInt();
		System.out.print("Year of birth: ");
		int year = scan.nextInt();
		birthday[0] = day;
		birthday[1] = getMonth(month);
		birthday[2] = year;

		// Age
		int d = (int) Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
		int m = (int) Calendar.getInstance().get(Calendar.MONTH);
		int y = (int) Calendar.getInstance().get(Calendar.YEAR);
		int ageD = d - day;
		int ageM = m - month;
		if (ageD < 0) {
			month = month - 1;
		}
		int ageY = y - year;
		age = ageY + " years " + ageM + " months " + ageD + " days";

		// Hobby
		System.out.print("Favorite hobby: ");
		hobby = scan.next();

		// Favorite food
		System.out.print("Favorite food: ");
		food = scan.next();

		// Favorite color
		System.out.print("Favorite color: ");
		color = scan.next();

		// Favorite animal
		System.out.print("Favorite animal: ");
		animal = scan.next();

		// Height
		System.out.print("Height: ");
		int heightInches = scan.nextInt();
		getHeight(heightInches);

		// Weight
		System.out.print("Weight: ");
		weight = scan.nextInt();

		// Favorite book
		System.out.print("Favorite book: ");
		book = scan.next();

		// Favorite subject
		System.out.print("Favorite subject: ");
		subject = scan.next();

		scan.close();
	}

	private String getMonth(int m) {
		String month = "";
		if (m == 1) {
			month = "January";
		} else if (m == 2) {
			month = "February";
		} else if (m == 3) {
			month = "March";
		} else if (m == 4) {
			month = "April";
		} else if (m == 5) {
			month = "May";
		} else if (m == 6) {
			month = "June";
		} else if (m == 7) {
			month = "July";
		} else if (m == 8) {
			month = "August";
		} else if (m == 9) {
			month = "September";
		} else if (m == 10) {
			month = "October";
		} else if (m == 11) {
			month = "November";
		} else if (m == 12) {
			month = "December";
		}
		return month;
	}

	private void getHeight(int h) {
		int heightInches = h % 12;
		int heightFeet = (h - heightInches) / 12;
		height[0] = heightFeet;
		height[1] = heightInches;
	}

	private String recognizeName() {
		String s = "";
		if (name[0] == "Dhruv") {
			s = "You are awesome!";
		} else if (name[0] == "Shivam") {
			s = "Can you do your homework?";
		} else if (name[0] == "Aditi") {
			s = "Can we have Mexican for dinner?";
		} else if (name[0] == "Saurabh") {
			s = "I have nothing to say besides the fact that you are a butt face.";
		} else {
			s = "The system does not know you.";
		}
		return s;
	}

	private void printInfo() {
		System.out.println();
		System.out.println("Profile");
		System.out.println(name[0] + " " + name[1]);
		System.out.println(name[0] + " was born on " + birthday[0] + "/"
				+ birthday[1] + "/" + birthday[2]);
		System.out.println(name[0] + " is " + age + " old");
		System.out.println(name[0] + " likes to " + hobby);
		System.out.println(name[0] + " loves to eat " + food);
		System.out.println(name[0] + " likes " + color);
		System.out.println(name[0] + " would like " + animal + " as a pet");
		System.out.println(name[0] + " is " + height[0] + " feet " + height[1]
				+ " inches");
		System.out.println(name[0] + " weighs " + weight + " pounds");
		System.out.println(name[0] + " likes to read " + book);
		System.out.println(name[0] + " enjoys studying " + subject);
	}

}
