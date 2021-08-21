package com.controleestoque.dtos;

import java.io.Serializable;

import com.controleestoque.entity.Produto;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idProduto;
	
	private Long codigo;
	
	private String descricao;

	public ProdutoDTO(Produto produto) {
		super();
		this.idProduto = produto.getIdProduto();
		this.codigo = produto.getCodigo();
		this.descricao = produto.getDescricao();
	}

	public ProdutoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
