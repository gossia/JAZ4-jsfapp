package com.example.servletjspdemo.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


public interface IEntityBuilder<TEntity extends Entity> {
	
	public TEntity build(HttpServletRequest request) throws ServletException, IOException;

}
