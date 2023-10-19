package br.ufscar.dc.dsw.domain;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

@SuppressWarnings("serial")
@Entity
@Table(name = "Carro")
public class Carro extends AbstractEntity<Long> {

	@NotBlank(message = "{NotBlank.carro.modelo}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String modelo;

	@NotBlank(message = "{NotBlank.carro.carroceria}")
	@Size(max = 60)
	@Column(nullable = false, length = 60)
	private String carroceria;
    
	@NotNull(message = "{NotNull.carro.ano}")
	@Column(nullable = false, length = 5)
	private Integer ano;
	
	@NotNull(message = "{NotNull.carro.preco}")
	@NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	@Column(nullable = false, columnDefinition = "DECIMAL(8,2) DEFAULT 0.0")
	private BigDecimal preco;
    
	@NotNull(message = "{NotNull.carro.fabricante}")
	@ManyToOne
	@JoinColumn(name = "fabricante_id")
	private Fabricante fabricante;

    @NotNull(message = "{NotNull.carro.placa}")
	@Column(nullable = false, length = 10)
	private String placa;

    @NotNull(message = "{NotNull.carro.cor}")
	@Column(nullable = false, length = 20)
	private String cor;

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCarroceria() {
		return carroceria;
	}

	public void setCarroceria(String carroceria) {
		this.carroceria = carroceria;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

    public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

    public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
}


//Comentario teste