package com.subhajit.Medicare.Controllers.API.Admin.Product;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProductAdmin}.
 */
public class ProductAdmin__BeanDefinitions {
  /**
   * Get the bean definition for 'productAdmin'.
   */
  public static BeanDefinition getProductAdminBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProductAdmin.class);
    InstanceSupplier<ProductAdmin> instanceSupplier = InstanceSupplier.using(ProductAdmin::new);
    instanceSupplier = instanceSupplier.andThen(ProductAdmin__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
