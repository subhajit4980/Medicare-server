package com.subhajit.Medicare.Config;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EmailConfig}.
 */
public class EmailConfig__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EmailConfig apply(RegisteredBean registeredBean, EmailConfig instance) {
    AutowiredFieldValueResolver.forRequiredField("mailHost").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("mailPort").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
