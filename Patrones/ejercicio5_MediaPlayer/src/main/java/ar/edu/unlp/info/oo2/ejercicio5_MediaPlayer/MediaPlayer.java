package ar.edu.unlp.info.oo2.ejercicio5_MediaPlayer;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {
	private List<Media> media;
	
	public MediaPlayer() {
		media = new ArrayList<Media>();
	}
	
	public void addMedia(Media m) {
		this.media.add(m);
	}
	
	public List<Media> getMedia(){
		return this.media;
	}
}
