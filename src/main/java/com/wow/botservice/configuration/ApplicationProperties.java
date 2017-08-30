package com.wow.botservice.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "botservice.appication")
@Component
public class ApplicationProperties {
    
	private String tableDir;

	public String getTableDir() {
		return tableDir;
	}

	public void setTableDir(String tableDir) {
		this.tableDir = tableDir;
	}
    
}