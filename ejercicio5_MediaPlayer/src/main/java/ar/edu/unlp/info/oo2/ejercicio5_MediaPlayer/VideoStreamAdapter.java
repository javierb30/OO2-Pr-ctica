package ar.edu.unlp.info.oo2.ejercicio5_MediaPlayer;

public class VideoStreamAdapter implements Media{
	private VideoStream adaptee;
	
	public VideoStreamAdapter(VideoStream vS) {
		adaptee = vS;
	}

	public void play() {
		System.out.println(this.adaptee.reproduce());
	}
}
