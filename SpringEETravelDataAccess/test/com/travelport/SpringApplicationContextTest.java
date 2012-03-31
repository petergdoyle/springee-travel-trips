/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelport;

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
                    "resources/spring-config.xml",
                    "resources/spring-config-jpa.xml",
                    "resources/spring-config-datasource-hsql-embedded.xml"
                });
    }
}
