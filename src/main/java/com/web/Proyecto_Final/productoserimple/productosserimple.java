/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Configuration.java to edit this template
 */
package com.web.Proyecto_Final.productoserimple;

import com.web.Proyecto_Final.producto.producto;
import com.web.Proyecto_Final.productodao.productodao;
import com.web.Proyecto_Final.productoservicio.productoservicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class productosserimple implements productoservicio{
    
        @Autowired
    private productodao productodaso;
    
    @Override
    @Transactional(readOnly = true)
    public List<producto> listaproducto() {
         return (List<producto>) productodaso.findAll();
    }

    @Override
    @Transactional
    public void salvar(producto producto) {
        productodaso.save(producto);
    }

    @Override
    @Transactional
    public void borrar(producto producto) {
        productodaso.delete(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public producto localizarproducto(producto producto) {
       return productodaso.findById(producto.getCodigo_Producto()).orElse(producto);
    }

	@Override
	public List<producto> buscarPorNombre(String nombre_Producto) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public void actualizarCantidad(Long idProducto, int cantidad) {
    }

    
}
