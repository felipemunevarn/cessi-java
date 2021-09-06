import java.util.ArrayList;

public class App extends Logic{

	public static void main(String[] args) {
		ArrayList<Song> songs = new ArrayList<Song>();
		for (int i = 0; i < 3; i++) {
			Song temp = new Song("title" + i, "author" + i, i, "gender" + i);
			songs.add(temp);
		}
		for (int i = 0; i < 3; i++) {
			Song temp = new Song("title" + (i + 3), "author" + (3 - i), i + 4, "gender" + i);
			songs.add(temp);
		}
		longest(songs);
		quantByGender(songs, "gender8");
		quantByAuthor(songs, "author1");
		longestByAuthor(songs, "author2");
		songs.get(5).setLength(3673);
		totaLTimeMusic(songs);
	}
	


}
