package br.ufscar.dc.dsw.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.ufscar.dc.dsw.domain.Fabricante;
import br.ufscar.dc.dsw.service.spec.IFabricanteService;

@Controller
@RequestMapping("/fabricantes")
public class FabricanteController {
	
	@Autowired
	private IFabricanteService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Fabricante fabricante) {
		return "fabricante/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("fabricantes",service.buscarTodos());
		return "fabricante/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(@Valid Fabricante fabricante, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "fabricante/cadastro";
		}
		
		service.salvar(fabricante);
		attr.addFlashAttribute("sucess", "Fabricante inserida com sucesso.");
		return "redirect:/fabricantes/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("fabricante", service.buscarPorId(id));
		return "fabricante/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(@Valid Fabricante fabricante, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "fabricante/cadastro";
		}

		service.salvar(fabricante);
		attr.addFlashAttribute("sucess", "Fabricante editada com sucesso.");
		return "redirect:/fabricante/listar";
	}
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		if (service.fabricanteTemLivros(id)) {
			model.addAttribute("fail", "Fabricante não excluída. Possui livro(s) vinculado(s).");
		} else {
			service.excluir(id);
			model.addAttribute("sucess", "Fabricante excluída com sucesso.");
		}
		return listar(model);
	}
}