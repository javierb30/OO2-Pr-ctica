package ar.edu.unlp.info.oo2.ejercicio8_ToDoItem;

public class InProgress extends Etapa{
	
	public InProgress(ToDoItem item) {
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
