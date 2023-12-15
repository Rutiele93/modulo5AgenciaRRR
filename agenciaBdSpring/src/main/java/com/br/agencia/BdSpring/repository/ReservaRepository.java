package com.br.agencia.BdSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.agencia.BdSpring.model.Reservas;

public interface ReservaRepository extends JpaRepository<Reservas, Long>{

}
