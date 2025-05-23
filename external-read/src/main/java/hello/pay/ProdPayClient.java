package hello.pay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;

@Slf4j
public class ProdPayClient implements PayClient {
    @Override
    public void pay(int money) {
        log.info("운영 결제 money = {}", money);
    }
}
