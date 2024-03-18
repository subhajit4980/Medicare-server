package com.subhajit.Medicare.Services;

import com.subhajit.Medicare.Repository.UserRepository;
import freemarker.template.Configuration;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link PasswordService}.
 */
public class PasswordService__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'passwordService'.
   */
  private static BeanInstanceSupplier<PasswordService> getPasswordServiceInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordService>forConstructor(UserRepository.class, Configuration.class, EmailService.class, HttpServletRequest.class, PasswordEncoder.class)
            .withGenerator((registeredBean, args) -> new PasswordService(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4)));
  }

  /**
   * Get the bean definition for 'passwordService'.
   */
  public static BeanDefinition getPasswordServiceBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PasswordService.class);
    beanDefinition.setInstanceSupplier(getPasswordServiceInstanceSupplier());
    return beanDefinition;
  }
}
