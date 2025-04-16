package hello.selector;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.io.ObjectInputFilter;

import static org.junit.jupiter.api.Assertions.*;

public class ImportSelectorTest {

    @Test
    void staticConfig() throws Exception {
        //given
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(StaticConfig.class);

        //when
        HelloBean bean = appContext.getBean(HelloBean.class);

        //then
        assertNotNull(bean);
    }

    @Test
    void selectorConfig() throws Exception {
        //given
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(SelectorConfig.class);

        //when
        HelloBean bean = appContext.getBean(HelloBean.class);

        //then
        assertNotNull(bean);
    }


    @Configuration
    @Import(HelloConfig.class)
    public static class StaticConfig {

    }

    @Configuration
    @Import(HelloImportSelector.class)
    public static class SelectorConfig {

    }
}
