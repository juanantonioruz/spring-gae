package com.enjava;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF {
	private  final EntityManagerFactory emfInstance ;

	public EMF() {
		 emfInstance = Persistence
					.createEntityManagerFactory("transactions-optional");
	}

	public EntityManager getEM() {
		return emfInstance.createEntityManager();
	}
}