package com.app.crud.ventas.copia;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "ventas")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdVentas")
    private Long idVentas;

    @Column(name = "nombreProducto")
    private String nombreProducto;

    @Column(name = "NombreEmpleado")
    private String nombreEmpleado;

    @Column(name = "NumeroSerie")
    private String numeroSerie;

    @Column(name = "FechaVentas")
    private Date fechaVentas;

    @Column(name = "Monto")
    private Double monto;

    @Column(name = "Estado")
    private String estado;
    public Ventas() {
        
    }

	public Ventas(Long idVentas, String nombreProducto, String nombreEmpleado, String numeroSerie, Date fechaVentas,
			Double monto, String estado) {
		super();
		this.idVentas = idVentas;
		this.nombreProducto = nombreProducto;
		this.nombreEmpleado = nombreEmpleado;
		this.numeroSerie = numeroSerie;
		this.fechaVentas = fechaVentas;
		this.monto = monto;
		this.estado = estado;
	}
	

	public Long getIdVentas() {
		return idVentas;
	}

	public void setIdVentas(Long idVentas) {
		this.idVentas = idVentas;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public Date getFechaVentas() {
		return fechaVentas;
	}

	public void setFechaVentas(Date fechaVentas) {
		this.fechaVentas = fechaVentas;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	} 
}
