package ar.edu.unlp.info.oo2.ejercicio8_ToDoItem;

public class Paused extends Etapa{
	
	public Paused(ToDoItem item) {
		super(item);
	}

	@Override
	public void togglePause() {
		this.getContext().cambiarEstado(new Paused(this.getContext()));
		
	}

	@Override
	public void finish() {
		this.getContext().cambiarEstado(new Finished(this.getContext()));
		this.getContext().setFinishDate();
		
	}

}
