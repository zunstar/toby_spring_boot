package tobyspring.helloboot;

public class HelloController {

    public String hello(String name) {
        System.out.println(name);
        return "Hello " + name;
    }
}
