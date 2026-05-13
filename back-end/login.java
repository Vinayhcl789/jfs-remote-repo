package com.app.auth;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/*
    File Name   : LoginServlet.java
    Author      : Jakkula Vinay
    Created On  : 11-May-2026
    Description : Handles user authentication (Login)
*/

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Disable caching for security
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Basic validation
        if (username == null || password == null ||
            username.isEmpty() || password.isEmpty()) {

            request.setAttribute("error", "Username and Password are required");
            request.getRequestDispatcher("login.html").forward(request, response);
            return;
        }

        try (Connection con = DBConnection.getConnection()) {

            String sql = "SELECT password FROM users WHERE username = ?";
            PreparedStatement ps = con.prepareStatement(sql);
