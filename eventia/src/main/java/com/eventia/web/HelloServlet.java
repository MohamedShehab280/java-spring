package com.eventia.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class HelloServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("HelloServlet init, this runs once");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        System.out.println("doGet on thread " + Thread.currentThread().getName());

        String name = request.getParameter("name");
        response.setContentType("text/plain");

        if (name == null) {
            response.setStatus(400);
            response.getWriter().write("name is required");
            return;
        }

        response.setStatus(200);
        response.getWriter().write("Hello, " + name);
    }
}
