package tobyspring.config.autoconfig;

import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import tobyspring.config.MyAutoConfiguration;

@MyAutoConfiguration
public class ServerPropertiesConfig {

    @Bean
    public ServerProperties serverProperties(Environment env) {
//        ServerProperties properties = new ServerProperties();
//        properties.setContextPath(env.getProperty("contextPath"));
//        properties.setPort(Integer.parseInt(env.getProperty("port")));
//        return properties;

        return Binder.get(env).bind("", ServerProperties.class).get();
    }

}
