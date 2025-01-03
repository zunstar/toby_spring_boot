package tobyspring.helloboot;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
public class HelloRepositoryTest {

    @Autowired JdbcTemplate jdbcTemplate;
    @Autowired HelloRepository helloRepository;

    @Test
    void findHelloFailed() {
        Assertions.assertThat(helloRepository.findHello("skj")).isNull();
    }

    @Test
    void increaseCount() {
        Assertions.assertThat(helloRepository.countOf("skj")).isEqualTo(0);

        helloRepository.increaseCount("skj");
        Assertions.assertThat(helloRepository.countOf("skj")).isEqualTo(1);

        helloRepository.increaseCount("skj");
        Assertions.assertThat(helloRepository.countOf("skj")).isEqualTo(2);
    }

}
