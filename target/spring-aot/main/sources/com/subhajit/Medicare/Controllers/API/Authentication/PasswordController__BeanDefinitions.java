package com.subhajit.Medicare.Controllers.API.Authentication;

import com.subhajit.Medicare.Repository.UserRepository;
import com.subhajit.Medicare.Services.PasswordService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Bean definitions for {@link PasswordController}.
 */
public class PasswordController__BeanDefinitions {
  /**
   * Get the bean instance supplier for 'passwordController'.
   */
  private static BeanInstanceSupplier<PasswordController> getPasswordControllerInstanceSupplier() {
    return BeanInstanceSupplier.<PasswordController>forConstructor(UserRepository.class, HttpServletRequest.class, PasswordEncoder.class, PasswordService.class)
            .withGenerator((registeredBean, args) -> new PasswordController(args.get(0), args.get(1), args.get(2), args.get(3)));
  }

  /**
   * Get the bean definition for 'passwordController'.
   */
  public static BeanDefinition getPasswordControllerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(PasswordController.class);
    beanDefinition.setInstanceSupplier(getPasswordControllerInstanceSupplier());
    return beanDefinition;
  }
}
