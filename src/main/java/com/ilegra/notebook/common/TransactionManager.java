package com.ilegra.notebook.common;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.*;

public class TransactionManager {
    private static UserTransaction userTransaction = getUserTransaction();

    private static UserTransaction getUserTransaction() {
        try {
            return InitialContext.doLookup("java:comp/UserTransaction");
        } catch (NamingException e) {
            return null;
        }
    }

    public static void begin(EntityManager manager) {
        try {
            userTransaction.begin();
            manager.joinTransaction();
        } catch (NotSupportedException | SystemException e) {
            e.printStackTrace();
        }
    }

    public static void commit() {
        try {
            userTransaction.commit();

        } catch (RollbackException | HeuristicMixedException | HeuristicRollbackException | SystemException e) {
            e.printStackTrace();
        }
    }

    public static void rollback() {
        try {
            userTransaction.rollback();
        } catch (SystemException e) {
            e.printStackTrace();
        }
    }
}
