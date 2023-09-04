package com.bankchallenge.view.config;

import jakarta.faces.application.ResourceHandler;
import jakarta.servlet.DispatcherType;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.omnifaces.filter.HttpFilter;
import org.omnifaces.util.Servlets;

import java.io.IOException;
import java.util.Base64;

@WebFilter(filterName = "Security", urlPatterns = {"/bank-challenge/pages/*", "/pages/*", "/challenge/rest/*"}, dispatcherTypes = {DispatcherType.FORWARD,
        DispatcherType.REQUEST, DispatcherType.ERROR})
public class LoginFilter extends HttpFilter {

    private static final String USER_NAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public void doFilter(final HttpServletRequest request, final HttpServletResponse response, final HttpSession session, final FilterChain chain)
            throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if (request.getRequestURI().startsWith("/challenge") && authHeader == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setHeader("WWW-Authenticate", "Basic realm=\"UNAUTHORIZED\"");
        } else {
            if (authHeader != null && authHeader.startsWith("Basic ")) {
                authenticationRest(request, chain, response);
            } else {
                if (!request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) {
                    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
                    response.setHeader("Pragma", "no-cache");
                    response.setDateHeader("Expires", 0);
                }
                if (session != null && session.getAttribute("user") != null) {
                    chain.doFilter(request, response);
                } else {
                    Servlets.facesRedirect(request, response, "/login.xhtml");
                }
            }
        }
    }

    private void authenticationRest(final HttpServletRequest request, final FilterChain filterChain, final HttpServletResponse response) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String base64Credentials = authHeader.substring(6);
        String credentials = new String(Base64.getDecoder().decode(base64Credentials));

        String[] parts = credentials.split(":");
        if (parts.length == 2 && parts[0].equals(USER_NAME) && parts[1].equals(PASSWORD)) {
            filterChain.doFilter(request, response);
            return;
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setHeader("WWW-Authenticate", "Basic realm=\"UNAUTHORIZED\"");
    }

}