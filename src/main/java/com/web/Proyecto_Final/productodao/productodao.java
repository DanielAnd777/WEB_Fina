/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springboot/ApplRunner.java to edit this template
 */
package com.web.Proyecto_Final.productodao;

import com.web.Proyecto_Final.producto.producto;
import org.springframework.data.repository.CrudRepository;


public interface productodao extends CrudRepository<producto, Long> {
    
  
    
}
