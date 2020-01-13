package com.mkblogs.jndi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	
	@GetMapping("/testdb")
	public String getObject() throws Exception {
		Context ctx = new InitialContext();
		DataSource dataSource = (DataSource) ctx.lookup("java:/comp/env/jndiDataSource");
		String datasourceValue = dataSource.toString() + " :: "+ dataSource.getConnection(); 
		return datasourceValue;
	}
}
