package br.edu.unoesc.desafiofullstackunoesc.service.authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import br.edu.unoesc.desafiofullstackunoesc.service.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor{
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if(CookieService.getCookie(request, "usuarioId") != null){
            return true;
        }

        response.sendRedirect("/");
        return false;
    }
}
