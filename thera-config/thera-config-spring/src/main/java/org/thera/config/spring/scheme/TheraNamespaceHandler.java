package org.thera.config.spring.scheme;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.thera.config.ProviderConfig;

/**
 * @author liufu
 */
public class TheraNamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("provider", new TheraBeanDefinitionParser(ProviderConfig.class, true));
    }
}
