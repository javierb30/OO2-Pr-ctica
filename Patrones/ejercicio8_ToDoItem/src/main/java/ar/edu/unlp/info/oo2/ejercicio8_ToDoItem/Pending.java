package ar.edu.unlp.info.oo2.ejercicio8_ToDoItem;

import java.time.Duration;

public class Pending extends Etapa{
	
	public Pending(ToDoItem item) {
		super(item);
	}
	@Override
	public void start() {
		this.getContext().cambiarEstado(new InProgress(this.getContext()));
		this.getContext().setStartDate(); //Chequear
		
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
	}

	@Override
	public void finish() {
		// No hace nada
	}
	
	public Duration workedTime() {
		throw new RuntimeException("El objeto ToDoItem no se inició.");
	}

}
