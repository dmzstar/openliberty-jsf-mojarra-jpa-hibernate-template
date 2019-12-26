package org.bighoe;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class HelloBean {
	
	private String text = "hello";
	@Inject
	private EntityManager entityManager;
	
	@Transactional
	public void submit() {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername("user0");
		entityManager.persist(userEntity);
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}
