package com.controleestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.controleestoque.dtos.ProdutoDTO;
import com.controleestoque.entity.Produto;
import com.controleestoque.exceptions.ObjectNotFoundException;
import com.controleestoque.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto findById(Long idProduto) {
		Optional<Produto> produtoOptional = produtoRepository.findById(idProduto);
		return produtoOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado idProduto: " + idProduto));
	}
	
	public List<Produto> buscarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto gravarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto alterarProduto(Long idProduto, ProdutoDTO produtoDTO) {
		Produto produto = findById(idProduto);
		
		produto.setCodigo(produtoDTO.getCodigo());
		produto.setDescricao(produtoDTO.getDescricao());
		
		return produtoRepository.save(produto);
	}

	public void deletarProduto(Long idProduto) {
		Produto produto = findById(idProduto);
		
		try {
			produtoRepository.delete(produto);
		} catch (DataIntegrityViolationException e) {
			throw new com.controleestoque.resources.exceptions.DataIntegrityViolationException("Produto não pode ser deletado!");
		}
	}
}
