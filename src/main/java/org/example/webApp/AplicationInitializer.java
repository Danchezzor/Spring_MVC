package org.example.webApp;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class AplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        final var context  = new AnnotationConfigWebApplicationContext();
        context.scan("ru.netology");
        context.refresh();

        final var servlet = new DispatcherServlet(context);
        final var registration = servletContext.addServlet(
                "app", servlet
        );
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}