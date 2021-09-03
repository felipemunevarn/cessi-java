
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i < 101; i++) {
			System.out.print(i + ": ");
			if (i % 3 == 0) 
				System.out.print("Fizz");
			if (i % 5 == 0) 
				System.out.print("Buzz");
			System.out.println();			
		}
	}

}
