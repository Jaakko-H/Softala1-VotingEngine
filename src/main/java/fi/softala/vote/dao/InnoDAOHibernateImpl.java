package fi.softala.vote.dao;

// http://www.java2s.com/Code/Jar/j/Downloadjavaxpersistencejar.htm
// add a jar in Eclipse by right-clicking on the Project → Build Path → Configure Build Path.
// Under Libraries tab, click Add Jars or Add External JARs and give the Jar.

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import fi.softala.vote.model.Innovation;

@Transactional
public class InnoDAOHibernateImpl  {

	@PersistenceContext
	private EntityManager em;

	public void addNew(Innovation inno) {
		em.persist(inno);
	}

	public List<Innovation> findAll() {
		return em.createQuery("select innovation from InnoImpl innovation",
				Innovation.class).getResultList();
	}

	public Innovation find(long innoId) {
		return em.createQuery(
				"select innovation from InnoImpl innovation where innoId ="
						+ innoId, Innovation.class).getSingleResult();

	}

}
