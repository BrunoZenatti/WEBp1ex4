package br.ufscar.dc.dsw.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import br.ufscar.dc.dsw.domain.Fabricante;

@SuppressWarnings("unchecked")
public interface IFabricanteDAO extends CrudRepository<Fabricante, Long>{
	Fabricante findById(long id);
    Fabricante findByCNPJ (String CNPJ);
	List<Fabricante> findAll();
	Fabricante save(Fabricante fabricante);
	void deleteById(Long id);
}