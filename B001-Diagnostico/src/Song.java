
public class Song {
	private String title;
	private String author;
	private int length;
	private String gender;
	
	public Song(String title, String author, int length, String gender) {
		this.title = title;
		this.author = author;
		this.length = length;
		this.gender = gender;
	}

	public Song() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
