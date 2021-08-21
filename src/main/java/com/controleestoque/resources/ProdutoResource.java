package com.controleestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.controleestoque.dtos.ProdutoDTO;
import com.controleestoque.entity.Produto;
import com.controleestoque.services.ProdutoService;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/{idProduto}")
	public ResponseEntity<Produto> findById(@PathVariable Long idProduto) {
		Produto produto = produtoService.findById(idProduto);
		return ResponseEntity.ok().body(produto);
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> buscarProdutosPaginados() {
		List<Produto> produtos = produtoService.buscarProdutos();
		List<ProdutoDTO> produtoDTOs = produtos.stream().map(produto -> new ProdutoDTO(produto)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(produtoDTOs);
	}
	
	@PostMapping
	public ResponseEntity<Produto> gravarProduto(@RequestBody Produto produto) {
		Produto produtoRetorno = produtoService.gravarProduto(produto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idProduto").buildAndExpand(produtoRetorno.getIdProduto()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{idProduto}")
	public ResponseEntity<ProdutoDTO> alterarProduto(@PathVariable Long idProduto, @RequestBody ProdutoDTO produto) {
		Produto produtoRetorno = produtoService.alterarProduto(idProduto, produto);
		return ResponseEntity.ok().body(new ProdutoDTO(produtoRetorno));
	}
	
	@DeleteMapping(value = "/{idProduto}")
	public ResponseEntity<Void> delete(@PathVariable Long idProduto) {
		produtoService.deletarProduto(idProduto);
		
		return ResponseEntity.noContent().build();
	}
}






















