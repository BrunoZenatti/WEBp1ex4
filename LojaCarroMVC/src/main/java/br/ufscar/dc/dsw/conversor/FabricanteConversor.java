package br.ufscar.dc.dsw.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.ufscar.dc.dsw.domain.Fabricante;
import br.ufscar.dc.dsw.service.spec.IFabricanteService;

@Component
public class FabricanteConversor implements Converter<String, Fabricante>{

	@Autowired
	private IFabricanteService service;
	
	@Override
	public Fabricante convert(String text) {
		
		if (text.isEmpty()) {
		 return null;	
		}
		
		Long id = Long.valueOf(text);	
		return service.buscarPorId(id);
	}
}