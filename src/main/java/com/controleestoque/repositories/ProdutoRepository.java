package com.controleestoque.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.controleestoque.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(" select p FROM Produto p " +
    		" WHERE LOWER(p.descricao) like %:searchTerm% " )
     Page<Produto> buscarProdutoPagedSearch(
             @Param("searchTerm") String searchTerm, 
             Pageable pageable);
}
