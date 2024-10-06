package tobyspring.helloboot;



import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;

import java.io.IOException;

public class HellobootApplication {
    public static void main(String[] args) {
        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        WebServer webServer = serverFactory.getWebServer(servletContext -> {
            servletContext.addServlet("hello", new HttpServlet() {
                @Override
                public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
                    res.setStatus(200);
                    res.setHeader("Content-Type","text/plain");
                    res.getWriter().println("Hello Servlet!");
                }
            }).addMapping("/hello");
        });
        webServer.start();
    }
}
