package com.company.model;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class App {
    public static void main(String[] args) throws Exception{
        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Usuario u1 = new Usuario("nomeusuario", "emaiol", "senha");

            em.persist(u1);

            em.getTransaction().commit();

            em.close();
            emf.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
