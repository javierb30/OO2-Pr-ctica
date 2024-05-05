package ar.edu.unlp.info.oo2.ejercicio8_ToDoItem;

import java.time.Duration;
import java.time.LocalDateTime;

public class Finished extends Etapa{
	
	public Finished(ToDoItem item) {
		super(item);
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("El objeto ToDoItem no se encuentra en pause o in-progress");
		
	}

	@Override
	public void finish() {
		// No hace nada
		
	}

	@Override
	public Duration workedTime() {
		return Duration.between(this.getContext().getStartDate(), this.getContext().getFinishDate());
	}

	@Override
	public void addComment(String comment) {
		// No hace nada
		
	}

}
