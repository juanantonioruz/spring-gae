package com.enjava.web;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enjava.Alumno;
import com.enjava.EMF;

@Controller
public class Controlador {
	@Autowired
	Alumno alumno;

	@Autowired
	EMF emf;

	
    @RequestMapping(value="/helloW/nombre={nombre}")
    public String helloWorld(@PathVariable() String nombre, Model model) {
    	Alumno alumno=new Alumno();
    	alumno.setNombre(nombre);
    	EntityManager em = emf.getEM();
    	em.getTransaction().begin();
    	em.persist(alumno);
    	em.getTransaction().commit();
        model.addAttribute("message", "Hello World!"+alumno);
        this.alumno.setNombre(alumno.getNombre());
        
        return "helloWorld";
    }
    @RequestMapping(value="/helloW")
    public String helloWorld( Model model) {
    	model.addAttribute("message", "Hello World!"+alumno);
    	return "helloWorld";
    }

}
