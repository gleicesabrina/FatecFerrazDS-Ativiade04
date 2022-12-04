package com.gleice.funcionario.Repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gleice.funcionario.Model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long>{
    List<Projeto> findByTitulo(String tiulo);
    List<Projeto> findByDescricao(String descricao);
    List<Projeto> findByDataInicio(Date dataInicio);
    List<Projeto> findByDataFim(Date dataFim);
    List<Projeto> findByValorPrevisto(Double valorPrevisto);
    List<Projeto> findByValorGasto(Double valorGasto);

    
}