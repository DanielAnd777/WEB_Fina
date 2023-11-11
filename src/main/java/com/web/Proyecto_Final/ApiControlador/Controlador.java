/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springboot/ApplRunner.java to edit this template
 */
package com.web.Proyecto_Final.ApiControlador;

import com.web.Proyecto_Final.producto.producto;
import com.web.Proyecto_Final.productoservicio.productoservicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {

    @Autowired
    private productoservicio productoser;
    
    
 // al iniciar me dirige al inicio de secion
    @GetMapping("/")
    public String loginPage() {
        return "login"; // Página de inicio de sesión
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if ("user".equals(username) && "123".equals(password)) {
            return "redirect:/menu"; // Redirigir al menú si las credenciales son correctas
        } else {
            return "redirect:/?error=true"; // Redirigir a la página de inicio de sesión con un parámetro de error
        }
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu"; // Página del menú
    }

    // lista para mostrar los datos en el html
    @GetMapping("/index")
    public String inicio(Model model) {
        List<producto> productos = productoser.listaproducto();
        model.addAttribute("productos", productos);
        return "index";
    }

    @GetMapping("/anexar")
    public String anexar(producto producto) {
        return "cambiar";
    }

    @PostMapping("/salvar")
    public String salvar(@Valid producto producto, Errors errors) {
        if (errors.hasErrors()) {
            return "cambiar";
        }
        productoser.salvar(producto);
        return "redirect:/index";
    }

    @GetMapping("/modificar/{Codigo_Producto}")
    public String modificar(producto producto, Model model) {
        producto = productoser.localizarproducto(producto);
        model.addAttribute("producto", producto);
        return "cambiar";
    }
 //controllador para borrar algun dato del Inevntario
    @GetMapping("/borrar/{Codigo_Producto}")
    public String borrar(producto producto) {
        productoser.borrar(producto);
        return "redirect:/index";

    }
    
    
    @GetMapping("/factura")
    public String fac(Model model) {
        List<producto> productos = productoser.listaproducto();
        model.addAttribute("productos", productos);
        return "factura"; 
    }


}
