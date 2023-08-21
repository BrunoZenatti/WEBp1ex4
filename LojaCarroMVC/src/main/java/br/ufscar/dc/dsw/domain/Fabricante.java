package br.ufscar.dc.dsw.domain;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import br.ufscar.dc.dsw.validation.UniqueCNPJ;

@SuppressWarnings("serial")
@Entity
@Table(name = "Fabricante")
public class Fabricante extends AbstractEntity<Long> {

	@NotBlank
    @UniqueCNPJ (message = "{Unique.fabricante.CNPJ}")
	@Size(min = 18, max = 18, message = "{Size.fabricante.CNPJ}")
	@Column(nullable = false, unique = true, length = 60)
	private String CNPJ;
	
	@NotBlank
	@Size(min = 3, max = 60)
	@Column(nullable = false, unique = true, length = 60)
	private String nome;

    @NotNull(message = "{NotNull.fabricante.ano}")
	@Column(nullable = false, length = 5)
	private Integer ano;

    @NotNull(message = "{NotNull.fabricante.pais}")
	@Column(nullable = false, length = 50)
	private String pais;

	@OneToMany(mappedBy = "fabricante")
	private List<Carro> carros;
	
	public String getCNPJ() {
		return CNPJ;
	}

	public void setCNPJ(String CNPJ) {
		this.CNPJ = CNPJ;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

    public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Carro> getcarros() {
		return carros;
	}

	public void setcarros(List<Carro> carros) {
		this.carros = carros;
	}
}