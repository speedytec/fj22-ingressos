package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import br.com.caelum.ingresso.model.descontos.Desconto;

public class Ingresso {
	
	private Sessao sessao;
	
	private BigDecimal preco;
	
	public Ingresso(){
		
	}

	public Ingresso(Sessao sessao, Desconto tipoDesconto) {
		
		this.setSessao(sessao);
		this.setPreco(tipoDesconto.aplicarDescontoSobre(sessao.getPreco()));
	}

	public Sessao getSessao() {
		return sessao;
	}

	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	
	

}
