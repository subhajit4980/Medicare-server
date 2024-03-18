package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link MyDataService}.
 */
public class MyDataService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static MyDataService apply(RegisteredBean registeredBean, MyDataService instance) {
    AutowiredFieldValueResolver.forRequiredField("restTemplate").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
