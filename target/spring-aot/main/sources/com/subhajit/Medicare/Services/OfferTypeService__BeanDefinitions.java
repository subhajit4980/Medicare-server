package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OfferTypeService}.
 */
public class OfferTypeService__BeanDefinitions {
  /**
   * Get the bean definition for 'offerTypeService'.
   */
  public static BeanDefinition getOfferTypeServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OfferTypeService.class);
    InstanceSupplier<OfferTypeService> instanceSupplier = InstanceSupplier.using(OfferTypeService::new);
    instanceSupplier = instanceSupplier.andThen(OfferTypeService__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
