package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Security.JwtUtils;
import com.subhajit.Medicare.Tokens.TokenRepository;
import freemarker.template.Configuration;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link AuthService}.
 */
public class AuthService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'authService'.
   */
  private static BeanInstanceSupplier<AuthService> getAuthServiceInstanceSupplier() {
    return BeanInstanceSupplier.<AuthService>forConstructor(TokenRepository.class, UserRepository.class, PasswordEncoder.class, AuthenticationManager.class, JwtUtils.class, EmailService.class, Configuration.class)
            .withGenerator((registeredBean, args) -> new AuthService(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6)));
  }

  /**
   * Get the bean definition for 'authService'.
   */
  public static BeanDefinition getAuthServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(AuthService.class);
    beanDefinition.setInstanceSupplier(getAuthServiceInstanceSupplier());
    return beanDefinition;
  }
}
