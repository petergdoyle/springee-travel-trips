/*
 */
package com.springeetravel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author peter
 */
abstract public class SpringApplicationContextTest {

    protected static AbstractApplicationContext springContext;

    static {
        springContext = new FileSystemXmlApplicationContext(new String[]{
                    "src/WEB-INF/spring-config.xml",
                    "src/WEB-INF/spring-config-oxm.xml",
                    "src/WEB-INF/spring-config-jpa.xml",
                    "src/WEB-INF/spring-config-datasource-hsql-embedded.xml"
                });
    }
}
