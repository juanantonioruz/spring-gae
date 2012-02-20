package com.enjava.web;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    
    @RequestMapping(value="/form")
    public String helloForm( Model model) {
    	model.addAttribute("alumno", alumno);
    	return "helloForm";
    }
    @RequestMapping(value="/reciboForm", method=RequestMethod.POST)
    public String reciboForm( Model model , @ModelAttribute("alumno")Alumno a) {
    	System.out.println("Hello World!"+a.getNombre());
    	EntityManager em = emf.getEM();
    	em.getTransaction().begin();
    	em.merge(a);
    	em.getTransaction().commit();

    	return "alumnoModificado";
    }


}
