package ru.mail.mina.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "encoding", value = "UTF-8", description = "Encoding Param")})
public class FilterUTF8 implements Filter {
    private String code;

    public void init(FilterConfig fConfig) throws ServletException {
        code = fConfig.getInitParameter("encoding");
    }
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        String codeResponse = response.getCharacterEncoding();
        // установка кодировки ответа из параметров фильтра, если не установлена
        if (code != null && !code.equalsIgnoreCase(codeResponse)) {
            response.setCharacterEncoding(code);
        }
        String codeRequest = request.getCharacterEncoding();
        // установка кодировки запроса из параметров фильтра, если не установлена
        if (code != null && !code.equalsIgnoreCase(codeRequest)) {
            request.setCharacterEncoding(code);
        }
        chain.doFilter(request, response);
    }
    public void destroy() {
        code = null;
    }
}