package fiap.com.br.ursaChallenge.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import fiap.com.br.ursaChallenge.model.Produto;
import fiap.com.br.ursaChallenge.repository.ProdutoRepository;
import jakarta.validation.Valid;

@Controller
public class ProdutoController {
	
	private ProdutoRepository repP;
	
	@GetMapping("/index")
	public String retornaPagina() {
		return "index";
	}
	
	@GetMapping("/retorna_lista_produtos")
	public ModelAndView retornaListaProdutos() {

		List<Produto> listaP = repP.findAll();

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("produtos", listaP);

		return mv;
	}
	
	@GetMapping("/retornaFormCadProduto")
	public ModelAndView retornaFormCadProduto() {

		ModelAndView mv = new ModelAndView("form_cad_produtos");
		mv.addObject("produto", new Produto());
		return mv;
	}
	
	@PostMapping("/inserir_produto")
	public ModelAndView cadastroProduto(@Valid Produto novo_produto, BindingResult bd) {

		if (bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("form_cad_produtos");
			mv.addObject("produto", novo_produto);
			return mv;
		} else {
			Produto p = new Produto();
			p.setNm_produto(novo_produto.getNm_produto());
			p.setVl_preco(novo_produto.getVl_preco());
			p.setDs_descricao(novo_produto.getDs_descricao());
			p.setDs_categoria(novo_produto.getDs_categoria());

			repP.save(p);

			return new ModelAndView("redirect:/retorna_lista_produtos");
		}

	}
	
	@GetMapping("/remover_produto/{id}")
	public String removerProduto(@PathVariable Long id) {
		
		Optional<Produto> op = repP.findById(id);
		
		if(op.isPresent()) {
			repP.deleteById(id);
			return "redirect:/retorna_lista_produtos";
		} else {
			return "redirect:/retorna_lista_produtos";
		}
		
	}
	
	@GetMapping("/atualizar_produto/{id}")
	public ModelAndView retornaPaginaAtualizaProduto(@PathVariable Long id) {
		
		Optional<Produto> op = repP.findById(id);
		
		if(op.isPresent()) {
			Produto produto = op.get();
			
			ModelAndView mv = new ModelAndView("form_atualiza_produto");
			mv.addObject("produto",produto);
			return mv;
			
		} else {
			return new ModelAndView("redirect:/retorna_lista_produtos");
		}
		
	}
	
	@PostMapping("/atualizar_dados_produto/{id}")
	public ModelAndView atualizarProduto(@PathVariable Long id, @Valid Produto produto, BindingResult bd) {
		
		if(bd.hasErrors()) {
			ModelAndView mv = new ModelAndView("form_atualiza_produto");
			mv.addObject("produto",produto);
			return mv;
		} else {
			
			Optional<Produto> op = repP.findById(id);
			
			if(op.isPresent()) {
				Produto produto1 = op.get();
				
				produto1.setNm_produto(produto.getNm_produto());
				produto1.setVl_preco(produto.getVl_preco());
				produto1.setDs_descricao(produto.getDs_descricao());
				produto1.setDs_categoria(produto.getDs_categoria());
				
				repP.save(produto1);
				
				return new ModelAndView("redirect:/retorna_lista_produtos");
			} else {
				return new ModelAndView("redirect:/retorna_lista_produtos");
			}
		}
	}
	
	@GetMapping("/detalhes_produto/{id}")
	public ModelAndView retornaDetalhesProduto(@PathVariable Long id) {
	
		Optional<Produto> op = repP.findById(id);
		
		if(op.isPresent()) {
			Produto produto = op.get();
			
			ModelAndView mv = new ModelAndView("detalhes_produto");
			mv.addObject("produto", produto);
			return mv;
			
		} else {
			return new ModelAndView("redirect:/retorna_lista_produtos");
		}
		
	}
}