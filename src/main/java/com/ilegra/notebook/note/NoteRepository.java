package com.ilegra.notebook.note;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
@Transactional
public class NoteRepository {
    @PersistenceContext(unitName = "thorntail-unit")
    private EntityManager em;

    public Note save(Note note) {
        em.persist(note);
        return note;
    }

    public Note update(Note note) {
        Note note2 = em.merge(note);
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
