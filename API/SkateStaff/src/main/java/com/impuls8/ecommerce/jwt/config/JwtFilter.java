package com.impuls8.ecommerce.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtFilter extends GenericFilterBean {

	
	public static String secret = "CHMIX9-gatitos-Linux-y-Drama-20220405";
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authHeader = httpServletRequest.getHeader("authorization");
		
		if ( 
				( ("POST".equals(httpServletRequest.getMethod())) && (! httpServletRequest.getRequestURI().contains("/api/users/") )  ) ||
				( ("GET".equals(httpServletRequest.getMethod())) && (! httpServletRequest.getRequestURI().contains("/api/products/") )  )||
				("PUT".equals(httpServletRequest.getMethod())) ||
				("DELETE".equals(httpServletRequest.getMethod()))
				
				) {
			if (authHeader == null || !authHeader.startsWith("Impuls8 ") ) {
				throw new ServletException("1. Invalid Token!");
			}//if authHeader
			String token = authHeader.substring(7);
			try {
				Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
				claims.forEach( (key,value)->{
					System.out.println("key: " + key + " value: " + value);
				});
				request.setAttribute("claims", claims);
			} catch (SignatureException | MalformedJwtException | ExpiredJwtException e) {
				throw new ServletException("2. Invalid token.");
			}
			
			
			
		}//if Methods
		chain.doFilter(request, response);
	} 
}
