package com.company.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManager {

    private static EntityManagerFactory instanciaEMF = null;
    private static javax.persistence.EntityManager instanciaEM = null;

    static {
        instanciaEMF = Persistence.createEntityManagerFactory("myPersistenceUnit");
        instanciaEM = instanciaEMF.createEntityManager(); // garante que ele seja inicializado
    }

    public static EntityManagerFactory getEMF(){
        return instanciaEMF;
    }

    public static javax.persistence.EntityManager getEM(){
        return instanciaEM;
    }


}

