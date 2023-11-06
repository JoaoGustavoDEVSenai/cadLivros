package com.GereciamenteDeLivros.PrjLivros.LivroController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GereciamenteDeLivros.PrjLivros.LivroService.LivroService;
import com.GereciamenteDeLivros.PrjLivros.entities.Livros;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	public final LivroService livroService;

	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livros> getLivros(@PathVariable Long id) {
		Livros livro = livroService.getLivrosById(id);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Livros createLivros(@RequestBody Livros livros) {
		return livroService.saveLivros(livros);
	}

	public List<Livros> getAllLivros() {
		return livroService.getAllLivros();
	}

	@DeleteMapping("/{id}")
	public void deleteLivros(@PathVariable Long id) {
		livroService.deleteLivros(id);
	}
	
		@GetMapping
		public ResponseEntity<List<Livros>> getAllJogos(RequestEntity<Void> requestEntity) {
			String method = requestEntity.getMethod().name();
			String contentType = requestEntity.getHeaders().getContentType().toString();
			List<Livros> jogos = livroService.getAllLivros();
			return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
					.body(jogos);
		}
		
		@PutMapping("/{id}")
		public Livros updateLivros(@PathVariable Long id, @RequestBody Livros livros) {
		    return livroService.updateLivros(id, livros);
		}

}
