package ru.mail.mina.web.filter;

import javax.servlet.*;
import java.io.IOException;

public class RequestEncodeFilter implements Filter {

    public RequestEncodeFilter() {
        System.out.println("Request response encoder filter object has been created");
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
        response.setContentType("text/html; charset=UTF-8");
    }

    public void destroy() {
        //Default
    }
}