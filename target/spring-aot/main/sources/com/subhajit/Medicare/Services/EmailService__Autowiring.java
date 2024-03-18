package com.subhajit.Medicare.Services;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link EmailService}.
 */
public class EmailService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static EmailService apply(RegisteredBean registeredBean, EmailService instance) {
    AutowiredFieldValueResolver.forRequiredField("javaMailSender").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("config").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
