package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Tokens.TokenRepository;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LogoutService}.
 */
public class LogoutService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'logoutService'.
   */
  private static BeanInstanceSupplier<LogoutService> getLogoutServiceInstanceSupplier() {
    return BeanInstanceSupplier.<LogoutService>forConstructor(TokenRepository.class)
            .withGenerator((registeredBean, args) -> new LogoutService(args.get(0)));
  }

  /**
   * Get the bean definition for 'logoutService'.
   */
  public static BeanDefinition getLogoutServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(LogoutService.class);
    beanDefinition.setInstanceSupplier(getLogoutServiceInstanceSupplier());
    return beanDefinition;
  }
}
