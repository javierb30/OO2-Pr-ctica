package ar.edu.unlp.info.oo2.ejercicio8_ToDoItem;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Etapa {
	private ToDoItem context;
	
	public Etapa(ToDoItem item) {
		this.context = item;
	}
	
	public ToDoItem getContext() {
		return this.context;
	}
	
	public void start() {
		//NO hace nada
	}
	
	public abstract void togglePause();
	
	public abstract void finish();
	
	public Duration workedTime() {
		return Duration.between(this.getContext().getStartDate(), LocalDateTime.now());
	}
	
	public void addComment(String comment) {
		this.getContext().getComentarios().add(comment);
	}
}
