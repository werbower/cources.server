package com.softgroup.restserver.config.security;

import com.softgroup.token.JwtApi;
import com.softgroup.token.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by user on 22.03.2017.
 */
@Component
public class MyFilterOfJWT extends GenericFilterBean {
    @Autowired
    JwtApi jwtService;



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String xToken = httpServletRequest.getHeader("xToken");

         if (xToken!=null){
            UserProfile profileEntity = jwtService.profileFromToken(xToken);
            if (profileEntity!=null){
                SecurityContextHolder.getContext().setAuthentication(new ProfileUser(profileEntity));
            }
        }

        chain.doFilter(request,response);
    }
}
