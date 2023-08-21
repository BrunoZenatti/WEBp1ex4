package br.ufscar.dc.dsw.service.spec;

import java.util.List;
import br.ufscar.dc.dsw.domain.Carro;

public interface ICarroService {
	Carro buscarPorId(Long id);
	List<Carro> buscarTodos();
	void salvar(Carro carro);
	void excluir(Long id);
}