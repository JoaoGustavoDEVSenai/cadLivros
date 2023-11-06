package com.GereciamenteDeLivros.PrjLivros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GereciamenteDeLivros.PrjLivros.entities.Livros;

public interface LivroRepository extends JpaRepository<Livros, Long> {

}
