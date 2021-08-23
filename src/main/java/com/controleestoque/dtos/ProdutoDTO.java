package com.controleestoque.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.controleestoque.entity.Produto;

public class ProdutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idProduto;
	
	@NotNull(message = "O campo código não deve ser nulo")
	private Long codigo;
	
	@NotEmpty(message = "Campo Descrição é requerido!")
	@Length(min = 1, max = 300, message = "O campo Descrição deve ter entre 1 e 300 caracteres!")
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
