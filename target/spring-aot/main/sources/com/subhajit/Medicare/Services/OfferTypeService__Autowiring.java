package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link OfferTypeService}.
 */
public class OfferTypeService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static OfferTypeService apply(RegisteredBean registeredBean, OfferTypeService instance) {
    AutowiredFieldValueResolver.forRequiredField("offerTypeRepository").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
