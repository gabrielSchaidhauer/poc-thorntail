package com.ilegra.notebook.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHolder {
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("thorntail-unit");
    private static EntityManager manager = factory.createEntityManager();

    public static EntityManager getEntityManager() {
        return manager;
    }
}
