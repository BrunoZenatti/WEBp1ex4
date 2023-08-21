package br.ufscar.dc.dsw.service.spec;
import java.util.List;
import br.ufscar.dc.dsw.domain.Fabricante;
public interface IFabricanteService {
	Fabricante buscarPorId(Long id);
	List<Fabricante> buscarTodos();
	void salvar(Fabricante fabricante);
	void excluir(Long id);
	boolean fabricanteTemCarros(Long id);
}