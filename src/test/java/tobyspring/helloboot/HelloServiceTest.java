package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class HelloServiceTest {

    private static final HelloRepository getHelloRepositoryStub = new HelloRepository() {
        @Override
        public Hello findHello(String name) {
            return null;
        }

        @Override
        public void increaseCount(String name) {

        }
    };

    @Test
    void simpleHelloService(){
        SimpleHelloService simpleHelloService = new SimpleHelloService(getHelloRepositoryStub);

        String ret = simpleHelloService.sayHello("Test");

        Assertions.assertThat(ret).isEqualTo("Hello Test");
    }


    @Test
    void helloDecorator(){
        HelloDecorator decorator = new HelloDecorator(name -> name);

        String ret = decorator.sayHello("Test");
        Assertions.assertThat(ret).isEqualTo("*Test*");
    }
}
