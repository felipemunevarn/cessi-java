import java.util.ArrayList;

public class Logic {

	public static void longest(ArrayList<Song> list) {
		int max = 0;
		for (Song i : list) {
			if(max < i.getLength()) 
				max = i.getLength();
		}
		System.out.println("Canción más larga: " + max);
	}
	
	public static void quantByGender(ArrayList<Song> list, String gender) {
		int amount = 0;
		for (Song i : list) {
			if(gender.equalsIgnoreCase(i.getGender())) 
				amount++;
		}
		System.out.println("Del genero " + gender + " hay: " + amount);
	}
	
	public static void quantByAuthor(ArrayList<Song> list, String author) {
		int amount = 0;
		for (Song i : list) {
			if(author.equalsIgnoreCase(i.getAuthor())) 
				amount++;
		}
		System.out.println("Del autor " + author + " hay: " + amount);
	}
	
	public static void longestByAuthor(ArrayList<Song> list, String author) {
		ArrayList<Song> songsByAuthor = new ArrayList<Song>();
		for (Song i : list) {
			if(author.equalsIgnoreCase(i.getAuthor())) 
				songsByAuthor.add(i);
		}
		System.out.println("Del autor " + author + " ");
		longest(songsByAuthor);
	}
	
	public static void totaLTimeMusic(ArrayList<Song> list) {
		int seg = 0, min, hours;
		for (Song i : list) {
			seg += i.getLength();
		}
		hours = seg / 3600;
		min = (seg - hours * 3600) / 60;
		seg = seg - hours * 3600 - min * 60;
		System.out.println("Duración total " + hours + "h:" + min + "m:" + seg + "s");
	}
}
