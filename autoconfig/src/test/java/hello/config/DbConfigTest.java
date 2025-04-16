package hello.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class DbConfigTest {
    @Autowired DataSource dataSource;
    @Autowired TransactionManager transactionManager;
    @Autowired JdbcTemplate jdbcTemplate;

    @Test
    void checkBean() {
        // DbConfig의 @Configuration 을 주석처리해도 해당 테스트는 성공한다.
        // 스프링 부트가 자동으로 등록해주기 때문

        log.info("dataSource: {}", dataSource);
        log.info("transactionManager: {}", transactionManager);
        log.info("jdbcTemplate: {}", jdbcTemplate);

        assertNotNull(dataSource);
        assertNotNull(transactionManager);
        assertNotNull(jdbcTemplate);
    }
}