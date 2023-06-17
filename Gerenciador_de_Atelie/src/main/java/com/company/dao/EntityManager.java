package com.company.dao;

import com.company.model.Usuario;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManager {

    private static EntityManagerFactory instanciaEMF = null;
    private static javax.persistence.EntityManager instanciaEM = null;

    static {
        instanciaEMF = Persistence.createEntityManagerFactory("myPersistenceUnit");
        instanciaEM = instanciaEMF.createEntityManager();
    }

    public static EntityManagerFactory getEMF(){
        return instanciaEMF;
    }

    public static javax.persistence.EntityManager getEM(){
        return instanciaEM;
    }

    // Resto do código...


}

