package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProductService}.
 */
public class ProductService__BeanDefinitions {
  /**
   * Get the bean definition for 'productService'.
   */
  public static BeanDefinition getProductServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProductService.class);
    InstanceSupplier<ProductService> instanceSupplier = InstanceSupplier.using(ProductService::new);
    instanceSupplier = instanceSupplier.andThen(ProductService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
