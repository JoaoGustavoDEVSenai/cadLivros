package com.GereciamenteDeLivros.PrjLivros.LivroService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GereciamenteDeLivros.PrjLivros.entities.Livros;
import com.GereciamenteDeLivros.PrjLivros.repositories.LivroRepository;


@Service
public class LivroService {
	
private final LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public Livros getLivrosById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}
	
	public List<Livros> getAllLivros(){
		return livroRepository.findAll();
	}
	
	public Livros saveLivros(Livros livros) {
		return livroRepository.save(livros);
	}
	
	public void deleteLivros(Long id) {
		livroRepository.deleteById(id);
	}
	
	public Livros updateLivros(Long id, Livros novoLivros) {
		Optional<Livros> livroOptional = livroRepository.findById(id);
		
		if(livroOptional.isPresent() ) {
			Livros livroExistente = livroOptional.get();
			livroExistente.setDescricao(novoLivros.getDescricao() );
			livroExistente.setIsbn(novoLivros.getIsbn() );
			return livroRepository.save(livroExistente);
		} else {
			return null;
		}
	}
}
