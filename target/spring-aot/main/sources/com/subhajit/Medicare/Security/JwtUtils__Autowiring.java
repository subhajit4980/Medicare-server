package com.subhajit.Medicare.Security;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link JwtUtils}.
 */
public class JwtUtils__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static JwtUtils apply(RegisteredBean registeredBean, JwtUtils instance) {
    AutowiredFieldValueResolver.forRequiredField("jwtSecret").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("jwtExpirationMs").resolveAndSet(registeredBean, instance);
    AutowiredFieldValueResolver.forRequiredField("refresh_token_expiration").resolveAndSet(registeredBean, instance);
    return instance;
  }
}
