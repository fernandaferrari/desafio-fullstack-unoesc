package br.edu.unoesc.desafiofullstackunoesc.service.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class LoginInterceptorConfig  extends WebMvcConfigurerAdapter{

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(
                "/",
            "/login",
            "/cadastro",
            "/cadastrar",
            "/images/**",
            "/logar",
            "/vendor/**",
            "/js/**",
            "/fonts/**",
            "/css/**"
        );
    }
    
}
