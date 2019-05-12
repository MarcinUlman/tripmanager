package pl.edu.agh.mwo;

import java.util.ArrayList;
import java.util.List;

public class Trip {
	private String name;
	private String description;
	private List<Photo> photos;

	public Trip(String name, String description) {
		this.name = name;
		this.description = description;
		photos = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void addPhoto(Photo photo) {
		photos.add(photo);
	}

	public List<Photo> getPhotos() {
		return photos;
	}
}
