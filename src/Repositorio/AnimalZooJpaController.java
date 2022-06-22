/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositorio;

import Repositorio.exceptions.NonexistentEntityException;
import Modelo.AnimalZoo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author rodri
 */
public class AnimalZooJpaController implements Serializable {

    public AnimalZooJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void criar(AnimalZoo animalZoo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(animalZoo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void editar(AnimalZoo animalZoo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            animalZoo = em.merge(animalZoo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = animalZoo.getId();
                if (findAnimalZoo(id) == null) {
                    throw new NonexistentEntityException("The animalZoo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void apagar(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            AnimalZoo animalZoo;
            try {
                animalZoo = em.getReference(AnimalZoo.class, id);
                animalZoo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The animalZoo with id " + id + " no longer exists.", enfe);
            }
            em.remove(animalZoo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AnimalZoo> findAnimalZooEntities() {
        return findAnimalZooEntities(true, -1, -1);
    }

    public List<AnimalZoo> findAnimalZooEntities(int maxResults, int firstResult) {
        return findAnimalZooEntities(false, maxResults, firstResult);
    }

    private List<AnimalZoo> findAnimalZooEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AnimalZoo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public AnimalZoo findAnimalZoo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AnimalZoo.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnimalZooCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AnimalZoo> rt = cq.from(AnimalZoo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
