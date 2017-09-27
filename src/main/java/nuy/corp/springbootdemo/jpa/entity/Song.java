package nuy.corp.springbootdemo.jpa.entity;

import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Song extends BaseEntity {

	private String title;
	private int yearReleased;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYearReleased() {
		return yearReleased;
	}

	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}

}
