package com.gleice.funcionario.Repository;

import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gleice.funcionario.Model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByDataAdmissao(Date dataAdmissao);
    List<Funcionario> findBySalario(Double salario);
    List<Funcionario> findByCelular(String celular);
    List<Funcionario> findByEmail(String email);
        
}