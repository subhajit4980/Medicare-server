package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link SearchService}.
 */
public class SearchService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static SearchService apply(RegisteredBean registeredBean, SearchService instance) {
    AutowiredFieldValueResolver.forRequiredField("mongoClient").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("mongoConverter").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
