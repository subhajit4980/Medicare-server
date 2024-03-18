package com.subhajit.Medicare.Security;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AuthEntryPointJwt}.
 */
public class AuthEntryPointJwt__BeanDefinitions {
  /**
   * Get the bean definition for 'authEntryPointJwt'.
   */
  public static BeanDefinition getAuthEntryPointJwtBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthEntryPointJwt.class);
    beanDefinition.setInstanceSupplier(AuthEntryPointJwt::new);
    return beanDefinition;
  }
}
