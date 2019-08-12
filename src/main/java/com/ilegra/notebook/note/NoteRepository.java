package com.ilegra.notebook.note;

import com.ilegra.notebook.common.EntityManagerHolder;
import com.ilegra.notebook.common.TransactionManager;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class NoteRepository {
    private EntityManager em = EntityManagerHolder.getEntityManager();

    public Note save(Note note) {
        TransactionManager.begin(em);
        em.persist(note);
        TransactionManager.commit();
        return note;
    }

    public Note update(Note note) {
        TransactionManager.begin(em);
        Note note2 = em.merge(note);
        TransactionManager.commit();
        return note2;
    }

    public List<Note> findAll() {
        Query query = em.createQuery("SELECT n FROM Note n");
        return query.getResultList();
    }

    public Note findOne(UUID uuid) {
        return em.find(Note.class, uuid);
    }

    public void delete(Note note) {
        em.remove(note);
    }
}
