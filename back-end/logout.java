package com.app.auth;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
    File Name   : LogoutServlet.java
    Author      : Jakkula Vinay
    Created On  : 11-May-2026
    Description : Handles user logout by invalidating session
*/

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Prevent caching of secured pages
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        // Get existing session only
        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate(); // ✅ destroy session
        }

        // Redirect to logout confirmation page
        response.sendRedirect("logout.html");
    }
}