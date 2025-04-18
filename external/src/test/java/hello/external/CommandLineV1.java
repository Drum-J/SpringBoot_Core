package hello.external;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommandLineV1 {
    public static void main(String[] args) {

        //Run/Debug Configuration 에서 program arguments 추가!
        for (String arg : args) {
            log.info("arg: {}", arg);
        }
    }
}
