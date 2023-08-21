package br.ufscar.dc.dsw.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IFabricanteDAO;
import br.ufscar.dc.dsw.domain.Fabricante;
import br.ufscar.dc.dsw.service.spec.IFabricanteService;

@Service
@Transactional(readOnly = false)
public class FabricanteService implements IFabricanteService {

	@Autowired
	IFabricanteDAO dao;
	
	public void salvar(Fabricante fabricante) {
		dao.save(fabricante);
	}
	
	public void excluir(Long id) {
		dao.deleteById(id);
	}
	
	@Transactional(readOnly = true)
	public Fabricante buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}
	
	@Transactional(readOnly = true)
	public List<Fabricante> buscarTodos() {
		return dao.findAll();
	}
	
	@Transactional(readOnly = true)
	public boolean fabricanteTemCarros(Long id) {
		return !dao.findById(id.longValue()).getCarros().isEmpty(); 
	}
}