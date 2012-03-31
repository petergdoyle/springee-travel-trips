/*
 */
package com.springeetravel;

import com.springeetravel.domain.UniversalRecord;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author peter
 */
abstract public class SpringApplicationContextTest {

    protected static AbstractApplicationContext springContext;

    static {
        springContext = new ClassPathXmlApplicationContext(new String[]{
                    "WEB-INF/spring-config.xml",
                    "/WEB-INF/spring-config-mongodb.xml"
                });
    }

    public UniversalRecord buildUniversalRecord() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
