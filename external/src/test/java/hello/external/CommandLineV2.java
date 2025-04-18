package hello.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {
    public static void main(String[] args) {
        // 커맨드 라인에 `--` 를 먼저 넣으면 key=value 형식으로 저장이 된다.
        // ex) --url=devdb --username=dev_user --password=dev_pw mode=on

        for (String arg : args) {
            log.info("arg: {}", arg);
        }

        ApplicationArguments appArgs = new DefaultApplicationArguments(args);
        log.info("SourceArgs = {}", List.of(appArgs.getSourceArgs()));
        log.info("NonOptionArgs = {}", appArgs.getNonOptionArgs()); // -- 가 들어가지 않은 것 -> mode=on
        //OptionsNames = [password, url, username] key=value 에서 value 만 출력됨
        log.info("OptionsNames = {}", appArgs.getOptionNames());

        Set<String> optionNames = appArgs.getOptionNames();
        // key=value 형식으로 출력하기
        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, appArgs.getOptionValues(optionName));
        }

        List<String> url = appArgs.getOptionValues("url");
        List<String> username = appArgs.getOptionValues("username");
        List<String> password = appArgs.getOptionValues("password");
        List<String> mode = appArgs.getOptionValues("mode"); // mode 는 -- 옵션이 없음!

        log.info("url = {}", url); // url = [devdb]
        log.info("username = {}", username); // username = [dev_user]
        log.info("password = {}", password); // password = [dev_pw]
        log.info("mode = {}", mode); // mode = null
    }
}
