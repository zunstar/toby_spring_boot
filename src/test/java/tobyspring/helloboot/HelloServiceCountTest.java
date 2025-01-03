package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.stream.IntStream;

@HelloBootTest
public class HelloServiceCountTest {

    @Autowired HelloService helloService;
    @Autowired HelloRepository helloRepository;

    @Test
    void sayHelloIncreaseCount(){
        IntStream.rangeClosed(1,10).forEach(count -> {
            helloService.sayHello("skj");
            Assertions.assertThat(helloRepository.countOf("skj")).isEqualTo(count);
        });
    }
}
