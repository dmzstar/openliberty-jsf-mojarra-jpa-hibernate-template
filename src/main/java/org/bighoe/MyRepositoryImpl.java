package org.bighoe;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@ApplicationScoped
public class MyRepositoryImpl implements MyRepository{

	@Override
	public void hello() {
		
	}
	
}
