package com.app.crud.ventas.servicios;

import com.app.crud.repositorio.Ventarepositorio;
import com.app.crud.ventas.copia.Ventas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ventasservicioimpl implements ventaservicio {

    @Autowired
    private Ventarepositorio repositorio;

    @Override
    public List<Ventas> listarVentas() {
        return repositorio.findAll();
    }

    @Override
    public void delete(Long idVenta) {
        repositorio.deleteById(idVenta);
    }

    @Override
    public Optional<Ventas> listarPorId(Long idVentas) {
        return repositorio.findById(idVentas);
    }

    @Override
    public int guardarVenta(Ventas venta) {
        int resp = 0;
        Ventas ventas = repositorio.save(venta);
        if (!ventas.equals(null)){
            resp = 1;
        }
        return resp;
    }
    @Override
    public Ventas obtenerVentaPorId(Long idVentas) {
        Optional<Ventas> venta = repositorio.findById(idVentas);
        return venta.orElse(null);
    }

    @Override
	public List<Ventas> listar(String palabraClave) {
		if(palabraClave!= null) {
			return repositorio.findAll(palabraClave);
		}
		return (List<Ventas>)repositorio.findAll();
	}	
	
}
