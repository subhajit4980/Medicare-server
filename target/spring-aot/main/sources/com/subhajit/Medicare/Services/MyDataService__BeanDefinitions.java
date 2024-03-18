package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link MyDataService}.
 */
public class MyDataService__BeanDefinitions {
  /**
   * Get the bean definition for 'myDataService'.
   */
  public static BeanDefinition getMyDataServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(MyDataService.class);
    InstanceSupplier<MyDataService> instanceSupplier = InstanceSupplier.using(MyDataService::new);
    instanceSupplier = instanceSupplier.andThen(MyDataService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
