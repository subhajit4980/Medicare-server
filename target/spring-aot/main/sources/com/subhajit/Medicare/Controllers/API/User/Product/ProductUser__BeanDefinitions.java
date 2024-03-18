package com.subhajit.Medicare.Controllers.API.User.Product;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link ProductUser}.
 */
public class ProductUser__BeanDefinitions {
  /**
   * Get the bean definition for 'productUser'.
   */
  public static BeanDefinition getProductUserBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(ProductUser.class);
    InstanceSupplier<ProductUser> instanceSupplier = InstanceSupplier.using(ProductUser::new);
    instanceSupplier = instanceSupplier.andThen(ProductUser__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
