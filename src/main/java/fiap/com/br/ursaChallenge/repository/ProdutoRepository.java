package fiap.com.br.ursaChallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fiap.com.br.ursaChallenge.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{}
