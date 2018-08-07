package br.com.caelum.ingresso.validacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import br.com.caelum.ingresso.model.Sessao;

public class GerenciadorDeSessao {
	
	
	private List<Sessao> sessoesDaSala;
	
	public GerenciadorDeSessao(List<Sessao> sessoesDaSala){
		this.sessoesDaSala = sessoesDaSala;
		
		
	}
	
	private boolean horarioISConflitante(Sessao sessaoExistente, Sessao sessaoNova){
		
			boolean novaTerminaAntesdaExistente = sessaoNova.getHorariotermino().isBefore(sessaoExistente.getHorariotermino());
			boolean novaComecadepoisDaExistente = sessaoNova.getHorario().isAfter(sessaoExistente.getHorariotermino());
			
			if(novaTerminaAntesdaExistente||novaComecadepoisDaExistente){
				return false;
			}

		
		
		return true;
	}
	
	public boolean cabe(Sessao sessaoNova){
		
		
		return sessoesDaSala.stream().noneMatch(sessaoExistente -> horarioISConflitante(sessaoExistente, sessaoNova));
	}
	

	
}
