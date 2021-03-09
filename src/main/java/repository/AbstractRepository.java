package repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;

import model.Usuario;

public class AbstractRepository <E> {
	protected EntityManager em;
	protected Class entityClass;
	
	public AbstractRepository() {
		em = Persistence.createEntityManagerFactory("bankline").createEntityManager();
		this.entityClass = (Class<E>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		//System.out.println("Conectando: " + em!=null);
	}
	public void save(E e) {
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
	}
	public void update(E e) {
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
	}
	
	public void delete(Integer id) {
		E entity = find(id);
		if(entity != null) {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		}
	}
	
	public List<E> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public E find(Integer id) {
		Object entity = em.find(entityClass, id);
		return (E) entity;
	}

}
