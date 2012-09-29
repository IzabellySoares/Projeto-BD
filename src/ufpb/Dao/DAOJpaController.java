/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ufpb.Dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import ufpb.Dao.exceptions.NonexistentEntityException;
import ufpb.Dao.exceptions.PreexistingEntityException;
import ufpb.Hibernate.util.HibernateUtil;

/**
 *
 * @author Izabelly
 */
public class DAOJpaController implements Serializable {

    private EntityManager em = HibernateUtil.getInstance().getFactory().createEntityManager();

    public void create(Object objeto) throws PreexistingEntityException, Exception {
        em = null;
        try {

            em = HibernateUtil.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();


        } catch (Exception ex) {

            em.getTransaction().rollback();


            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Object objeto) throws NonexistentEntityException, Exception {
        em = null;
        try {
            em = HibernateUtil.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            objeto = em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception ex) {
            em.getTransaction().rollback();
            throw ex;


        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id, Class c) throws NonexistentEntityException {
        em = null;
        try {
            em = HibernateUtil.getInstance().getFactory().createEntityManager();
            em.getTransaction().begin();
            Object objeto;

            try {
                objeto = em.getReference(c, id);
            } catch (EntityNotFoundException enfe) {
                em.getTransaction().rollback();
                throw new NonexistentEntityException("Erro ao excluir" + enfe);
            }
            em.remove(objeto);
            em.getTransaction().commit();

        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Object> findEntities(Class c) {
        em = HibernateUtil.getInstance().getFactory().createEntityManager();
        try {
            Query q = em.createQuery("select object(o) from " + c.getSimpleName() + " as o");
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Object findObject(Integer id, Class c) {
        em = null;
        try {
            em = HibernateUtil.getInstance().getFactory().createEntityManager();
            return em.find(c, id);

        } finally {
            em.close();
        }
    }
}
