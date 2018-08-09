package br.com.caelum.ingresso.model.descontos;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.ingresso.model.Filme;
import br.com.caelum.ingresso.model.Ingresso;
import br.com.caelum.ingresso.model.Lugar;
import br.com.caelum.ingresso.model.Sala;
import br.com.caelum.ingresso.model.Sessao;
import br.com.caelum.ingresso.model.TipoDeIngresso;

public class DescontoTest {

	
	
	@Test
	public void naoDeveConcederDescontoParaingressoNormal(){
		Lugar lugar= new Lugar("A",1);
		
		Sala sala = new Sala("Eldorado 'imax", new BigDecimal("20.5"));
		Filme filme = new Filme("rogue one" , Duration.ofMinutes(120),"Sci-fi",new BigDecimal("12"));
		Sessao sessao = new Sessao(LocalTime.parse("10:00:00"),filme,sala);
		Ingresso ingresso= new Ingresso(sessao, TipoDeIngresso.INTEIRO,lugar);
		
		BigDecimal precoEsperado = new BigDecimal("32.50");
		Assert.assertEquals(precoEsperado,  ingresso.getPreco());
	}
}



