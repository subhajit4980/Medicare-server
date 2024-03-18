package com.subhajit.Medicare.Controllers.API.Admin.Offer;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link OfferTypeController}.
 */
public class OfferTypeController__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static OfferTypeController apply(RegisteredBean registeredBean,
      OfferTypeController instance) {
    AutowiredFieldValueResolver.forRequiredField("offerTypeService").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
