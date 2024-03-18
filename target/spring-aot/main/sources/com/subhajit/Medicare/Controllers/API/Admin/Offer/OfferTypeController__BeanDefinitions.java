package com.subhajit.Medicare.Controllers.API.Admin.Offer;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link OfferTypeController}.
 */
public class OfferTypeController__BeanDefinitions {
  /**
   * Get the bean definition for 'offerTypeController'.
   */
  public static BeanDefinition getOfferTypeControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(OfferTypeController.class);
    InstanceSupplier<OfferTypeController> instanceSupplier = InstanceSupplier.using(OfferTypeController::new);
    instanceSupplier = instanceSupplier.andThen(OfferTypeController__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
