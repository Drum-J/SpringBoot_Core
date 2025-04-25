package hello.order.v1;

import hello.order.OrderService;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class OrderServiceV1 implements OrderService {

    private final MeterRegistry registry;

    private AtomicInteger stock = new AtomicInteger(100);

    public OrderServiceV1(MeterRegistry registry) {
        this.registry = registry;
    }

    /**
     * 커스텀 메트릭은 최소 1번 호출 해야 등록이 됨!
     * 서버 실행 직후 /actuator/metrics 에 my.order 를 찾아보면 없음 ㅠㅠ
     */
    @PostConstruct
    public void metricInit() {
        log.info("주문,취소 메트릭 초기화");
        // ?tag=method:order
        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "order")
                .description("order")
                .register(registry);

        // ?tag=method:cancel
        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("order")
                .register(registry);
    }


    @Override
    public void order() {
        log.info("주문");
        stock.decrementAndGet();

        Counter.builder("my.order") // 카운터 메트릭 생성
                .tag("class", this.getClass().getName())
                .tag("method", "order") // method 이름으로 구분 가능
                .description("order")
                .register(registry) // 메트릭 등록
                .increment(); // 값 1 증가
    }

    @Override
    public void cancel() {
        log.info("취소");
        stock.incrementAndGet();

        Counter.builder("my.order")
                .tag("class", this.getClass().getName())
                .tag("method", "cancel")
                .description("order")
                .register(registry)
                .increment();
    }

    @Override
    public AtomicInteger getStock() {
        return stock;
    }
}
