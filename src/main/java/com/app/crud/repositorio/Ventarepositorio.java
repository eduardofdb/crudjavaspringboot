package com.app.crud.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.crud.ventas.copia.Ventas;

@Repository
public interface Ventarepositorio extends JpaRepository<Ventas, Long> {
	@Query("SELECT v FROM Ventas v WHERE "
			+ " CONCAT(v.idVentas, v.nombreEmpleado, v.nombreProducto, v.numeroSerie, v.fechaVentas, v.monto)"
			+ " LIKE %?1%")
	public List<Ventas> findAll(String palabraClave);
}