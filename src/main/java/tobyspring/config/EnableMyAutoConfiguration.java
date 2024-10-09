package tobyspring.config;

import org.springframework.context.annotation.Import;
import tobyspring.config.autoconfig.DispatcherServerConfig;
import tobyspring.config.autoconfig.TomcatWebServerConfig;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import({DispatcherServerConfig.class, TomcatWebServerConfig.class})
public @interface EnableMyAutoConfiguration {
}
