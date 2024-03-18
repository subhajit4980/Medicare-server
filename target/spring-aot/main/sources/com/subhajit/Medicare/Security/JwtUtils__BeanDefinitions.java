package com.subhajit.Medicare.Security;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link JwtUtils}.
 */
public class JwtUtils__BeanDefinitions {
  /**
   * Get the bean definition for 'jwtUtils'.
   */
  public static BeanDefinition getJwtUtilsBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(JwtUtils.class);
    InstanceSupplier<JwtUtils> instanceSupplier = InstanceSupplier.using(JwtUtils::new);
    instanceSupplier = instanceSupplier.andThen(JwtUtils__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
