package ar.edu.unlp.info.oo2.ejercicio5_MediaPlayer;

public class VideoFile implements Media {
	
	private String video;
	
	public VideoFile() {
		this.video = "VideoFile";
	}
	
	public void play() {
		System.out.println(this.video);
	}
}
