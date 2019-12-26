package org.bighoe;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.omnifaces.cdi.Startup;

//@Startup
@ApplicationScoped
public class EntityManagerProducer {
	
	//@PersistenceUnit
	//private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tdd");
	@PersistenceUnit(name = "test")
	private EntityManagerFactory entityManagerFactory;
	
	//private EntityManagerFactory entityManagerFactory;
	
	@PostConstruct
	public void onCreate() {
		
		/**
		Map<String, Object> props = new HashMap<>();
		props.put("javax.persistence.bean.manager", beanManager);
		entityManagerFactory = Persistence.createEntityManagerFactory("tdd", props);
		*/
		
	}
	
	@Produces
	@RequestScoped
	public EntityManager create() {
		System.out.println("================================================== create EntityManager");
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		return entityManager;
	}

	public void dispose(@Disposes EntityManager entityManager) {
		System.out.println("================================================== dispose close entityManager");
		if (entityManager.isOpen()) {
			entityManager.close();
		} else {
			
		}
	}
	
}
