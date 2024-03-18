package com.subhajit.Medicare.Utils;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link AppConstant}.
 */
public class AppConstant__BeanDefinitions {
  /**
   * Get the bean definition for 'appConstant'.
   */
  public static BeanDefinition getAppConstantBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AppConstant.class);
    beanDefinition.setInstanceSupplier(AppConstant::new);
    return beanDefinition;
  }
}
