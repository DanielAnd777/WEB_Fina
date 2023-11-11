/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springboot/ApplRunner.java to edit this template
 */
package com.web.Proyecto_Final.productoservicio;

import com.web.Proyecto_Final.producto.producto;
import java.util.List;


public interface productoservicio {
    
    public List<producto> listaproducto();
    
    public void salvar(producto producto);
    
    public void borrar(producto producto);
    
    public producto localizarproducto(producto producto);

	public List<producto> buscarPorNombre(String Nombre_Producto);

    public void actualizarCantidad(Long idProducto, int cantidad);

   
    
}
