package br.com.caelum.ingresso.model;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Sessao {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
	
	private LocalTime horario;
	
	@ManyToOne   //uma sala pode ter varios filmes
	private Sala sala;
	
	@ManyToOne
	private Filme filme;

	
	/** 
	 * @deprecated hibernate only
	 */
	public Sessao(){
		
	}
	
	public Sessao(LocalTime horario,Filme filme, Sala sala){
		
		this.horario=horario;
		this.filme=filme;
		this.sala=sala;
		
	}
	
	
	public LocalTime getHorariotermino(){
		
		return this.horario.plusMinutes(filme.getDuracao().toMinutes());
	}
}
