package com.celiosato.cliente.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.celiosato.cliente.domain.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

	@Query("select s from Servico s join s.cliente c "
			+ "where upper( c.nome ) like upper (concat('%', :nome,'%')) and MONTH(s.data) =:mes ")
	List<Servico> findByNomeClienteAndMes(@Param("nome") String nome, @Param("mes") Integer mes);

}
