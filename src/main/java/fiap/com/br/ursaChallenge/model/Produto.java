package fiap.com.br.ursaChallenge.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tb_produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_produto;
	@NotEmpty(message = "Não é possível cadastrar um produto sem nome")
	private String nm_produto;
	@NotEmpty(message = "Não é possível cadastrar um produto sem preço")
	private Float vl_preco;
	private String ds_descricao;
	private String ds_categoria;
	
	public Produto() {}
	
	public Produto(int id_produto,
			@NotEmpty(message = "Não é possível cadastrar um produto sem nome") String nm_produto,
			@NotEmpty(message = "Não é possível cadastrar um produto sem preço") Float vl_preco, String ds_descricao,
			String ds_categoria) {
		this.id_produto = id_produto;
		this.nm_produto = nm_produto;
		this.vl_preco = vl_preco;
		this.ds_descricao = ds_descricao;
		this.ds_categoria = ds_categoria;
	}
	
	public int getId_produto() {
		return id_produto;
	}
	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}
	public String getNm_produto() {
		return nm_produto;
	}
	public void setNm_produto(String nm_produto) {
		this.nm_produto = nm_produto;
	}
	public Float getVl_preco() {
		return vl_preco;
	}
	public void setVl_preco(Float vl_preco) {
		this.vl_preco = vl_preco;
	}
	public String getDs_descricao() {
		return ds_descricao;
	}
	public void setDs_descricao(String ds_descricao) {
		this.ds_descricao = ds_descricao;
	}
	public String getDs_categoria() {
		return ds_categoria;
	}
	public void setDs_categoria(String ds_categoria) {
		this.ds_categoria = ds_categoria;
	}

}
