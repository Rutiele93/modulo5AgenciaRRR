package com.br.agencia.BdSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.agencia.BdSpring.model.Clientes;

public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
