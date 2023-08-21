package br.ufscar.dc.dsw;

import java.math.BigDecimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import br.ufscar.dc.dsw.dao.ICarroDAO;
import br.ufscar.dc.dsw.dao.IFabricanteDAO;
import br.ufscar.dc.dsw.domain.Carro;
import br.ufscar.dc.dsw.domain.Fabricante;

@SpringBootApplication
public class LojaCarroMvcApplication {
	public static void main(String[] args) {
		SpringApplication.run(LojaCarroMvcApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(IFabricanteDAO fabricanteDAO, ICarroDAO carroDAO) {
		return (args) -> {	
			Fabricante f1 = new Fabricante();
			f1.setCNPJ("55.789.390/0008-99");
			f1.setNome("Volkswagen");
			f1.setAno("1937");
			f1.setPais("Alemanha");
			fabricanteDAO.save(f1);
			
			Fabricante f2 = new Fabricante();
			f2.setCNPJ("71.150.470/0001-40");
			f2.setNome("Chevrolet");
			f2.setAno("1911");
			f2.setPais("Estados Unidos");
			fabricanteDAO.save(f2);
			
			Fabricante f3 = new Fabricante();
			f3.setCNPJ("32.106.536/0001-82");
			f3.setNome("Toyota");
			f3.setAno("1937");
			f3.setPais("Japão");
			fabricanteDAO.save(f3);

			Fabricante f4 = new Fabricante();
			f4.setCNPJ("64.115.784/0002-65");
			f4.setNome("Hyundai");
			f4.setAno("1967");
			f4.setPais("Coréia do Sul");
			fabricanteDAO.save(f4);	

			Fabricante f5 = new Fabricante();
			f5.setCNPJ("23.335.559/0003-32");
			f5.setNome("Ferrari");
			f5.setAno("1929");
			f5.setPais("Itália");
			fabricanteDAO.save(f5);

			Carro c1 = new Carro();
			c1.setModelo("Gol");
			c1.setCarroceria("Hetch");
			c1.setAno(2010);
			c1.setPreco(BigDecimal.valueOf(25000.9));
			c1.setPlaca("OLPD7279");
			c1.setCor("Prata");
			c1.setFabricante(f1);
			carroDAO.save(c1);
			
			Carro c2 = new Carro();
			c2.setModelo("Onix");
			c2.setCarroceria("Hetch");
			c2.setAno(2019);
			c2.setPreco(BigDecimal.valueOf(55000.9));
			c2.setPlaca("MRJC2846");
			c2.setCor("Preto");
			c2.setFabricante(f2);
			larroDAO.save(c2);
			
			Carro c3 = new Carro();
			c3.setModelo("Corolla");
			c3.setCarroceria("Sedan");
			c3.setAno(2022);
			c3.setPreco(BigDecimal.valueOf(70000.9));
			c3.setPlaca("CAPT3333");
			c3.setCor("Azul");
			c3.setFabricante(f3);
			carroDAO.save(c3);			

			Carro c4 = new Carro();
			c4.setModelo("HB20");
			c4.setCarroceria("Hetch");
			c4.setAno(2018);
			c4.setPreco(BigDecimal.valueOf(40000.9));
			c4.setPlaca("BNYT2332");
			c4.setCor("Branco");
			c4.setFabricante(f4);
			carroDAO.save(c4);	

			Carro c5 = new Carro();
			c5.setModelo("SF90");
			c5.setCarroceria("Esportivo");
			c5.setAno(2020);
			c5.setPreco(BigDecimal.valueOf(200000.9));
			c5.setPlaca("BZTB4358");
			c5.setCor("Vermelho");
			c5.setFabricante(f5);
			carroDAO.save(c5);		
		};
	}
}