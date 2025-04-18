package hello.external;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class OsEnv {
    public static void main(String[] args) {
        Map<String, String> envMap = System.getenv();
        for (String key : envMap.keySet()) {
            log.info("env {} = {}", key, envMap.get(key));
        }

        /* OS 환경 변수에 DB 접근 URL 세팅하고 읽어서 사용할 수 있다.
        // DBURL=dev.db.com 개발 서버
        // DBURL=prod.db.com 운영 서버
        String dburl = System.getenv("DBURL");
        */
    }
}
