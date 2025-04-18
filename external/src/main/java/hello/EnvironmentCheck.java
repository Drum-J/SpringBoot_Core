package hello;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EnvironmentCheck {

    private final Environment env;

    public EnvironmentCheck(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void init() {
        // program arguments / Add VM option 어디에 추가해도 읽을 수 있다!
        String url = env.getProperty("url");
        String username = env.getProperty("my_username"); //시스템 환경 변수로 username 이 잡혀있다. my_username 으로 변경
        String password = env.getProperty("password");

        log.info("env url = {}", url);
        log.info("env username = {}", username);
        log.info("env password = {}", password);
    }
}
