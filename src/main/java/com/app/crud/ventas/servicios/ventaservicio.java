package com.app.crud.ventas.servicios;

import com.app.crud.ventas.copia.Ventas;

import java.util.List;
import java.util.Optional;

public interface ventaservicio {
    List<Ventas> listarVentas();

    public void delete(Long idVenta);

   public Optional<Ventas> listarPorId(Long idVentas);

    public int guardarVenta(Ventas venta);

    public Ventas obtenerVentaPorId(Long idVentas);
    
	public List<Ventas>listar(String palabraClave);

}
