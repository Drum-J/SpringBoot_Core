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
        String username = env.getProperty("username");
        String password = env.getProperty("password");

        log.info("env url = {}", url);
        log.info("env username = {}", username);
        log.info("env password = {}", password);
    }
}
