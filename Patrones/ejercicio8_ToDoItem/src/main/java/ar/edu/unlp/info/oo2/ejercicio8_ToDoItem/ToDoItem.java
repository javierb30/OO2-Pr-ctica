package ar.edu.unlp.info.oo2.ejercicio8_ToDoItem;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ToDoItem {
	private String nombre;
	private List<String> comentarios;
	private Etapa etapa;
	private LocalDateTime startDate;
	private LocalDateTime finishDate;
	
	public ToDoItem(String n) {
		this.nombre = n;
		this.comentarios = new ArrayList<String>();
		etapa = new Pending(this);
	}
	
	
	public List<String> getComentarios(){
		return this.comentarios;
	}
	
	public void cambiarEstado(Etapa nuevoEstado) {
		this.etapa = nuevoEstado;
	}
	
	public void setStartDate() {
		this.startDate = LocalDateTime.now();
	}
	
	public LocalDateTime getStartDate() {
		return this.startDate;
	}
	
	public LocalDateTime getFinishDate() {
		return this.finishDate;
	}
	
	public void setFinishDate() {
		this.finishDate = LocalDateTime.now();
	}
	
	public void start() {
		/* Pasa el ToDoItem a in-progress, siempre y cuando su estado actual sea
		pending. Si se encuentra en otro estado, no hace nada.*/
		this.etapa.start();
	}
	
	public void togglePause() {

		/* Pasa el ToDoItem a paused si su estado es in-progress, o a in-progress si su
		estado es paused. Caso contrario (pending o finished) genera un error
		informando la causa específica del mismo. */
		this.etapa.togglePause();
	}
	
	public void finish() {
		/*Pasa el ToDoItem a finished, siempre y cuando su estado actual sea
		 * in-progress o paused. Si se encuentra en otro estado, no hace nada.*/
		this.etapa.finish();
	}
	
	public Duration workedTime() {
		/*Retorna el tiempo que transcurrió desde que se inició el ToDoItem (start)
		* hasta que se finalizó. En caso de que no esté finalizado, el tiempo que
		* haya transcurrido hasta el momento actual. Si el ToDoItem no se inició,
		* genera un error informando la causa específica del mismo.*/
		return this.etapa.workedTime();
	}
	
	public void addComment(String comment) {
		/*Agrega un comentario al ToDoItem siempre y cuando no haya finalizado. Caso contrario no hace nada."*/
		this.etapa.addComment(comment);
	}
	
}