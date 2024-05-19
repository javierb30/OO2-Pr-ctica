package ar.edu.unlp.info.oo2.ejercicio5_MediaPlayer;

public class Audio implements Media{
	private String audio;
	
	public Audio() {
		this.audio = "audio";
	}
	
	public void play() {
		System.out.println(this.audio);
	}
}
