/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springboot/ApplRunner.java to edit this template
 */
package com.web.Proyecto_Final.producto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "producto")
public class producto implements Serializable {
    
  private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Codigo_Producto;

    
    @NotEmpty
    @Column(name = "nombreProducto")
    private String Nombre_Producto;

    @Min(1)
    private float Precio_Unitario;

    @Min(1)
    private int Cantidad_Producto;

    @NotEmpty
    private String Edad_de_Uso;
    


	public Long getCodigo_Producto() {
		return Codigo_Producto;
	}


	public void setCodigo_Producto(Long codigo_Producto) {
		Codigo_Producto = codigo_Producto;
	}

	public String getNombre_Producto() {
		return Nombre_Producto;
	}

	public void setNombre_Producto(String nombre_Producto) {
		Nombre_Producto = nombre_Producto;
	}

	public float getPrecio_Unitario() {
		return Precio_Unitario;
	}

	public void setPrecio_Unitario(float precio_Unitario) {
		Precio_Unitario = precio_Unitario;
	}

	public int getCantidad_Producto() {
		return Cantidad_Producto;
	}

	public void setCantidad_Producto(int cantidad_Producto) {
		Cantidad_Producto = cantidad_Producto;
	}

	public String getEdad_de_Uso() {
		return Edad_de_Uso;
	}

	public void setEdad_de_Uso(String edad_de_Uso) {
		Edad_de_Uso = edad_de_Uso;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    


}
