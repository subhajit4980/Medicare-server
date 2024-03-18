package com.subhajit.Medicare.Config;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ConfigurationClassUtils;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

/**
 * Bean definitions for {@link EmailConfig}.
 */
public class EmailConfig__BeanDefinitions {
  /**
   * Get the bean definition for 'emailConfig'.
   */
  public static BeanDefinition getEmailConfigBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(EmailConfig.class);
    beanDefinition.setTargetType(EmailConfig.class);
    ConfigurationClassUtils.initializeConfigurationClass(EmailConfig.class);
    InstanceSupplier<EmailConfig> instanceSupplier = InstanceSupplier.using(EmailConfig$$SpringCGLIB$$0::new);
    instanceSupplier = instanceSupplier.andThen(EmailConfig__Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'getJavaMailSender'.
   */
  private static BeanInstanceSupplier<JavaMailSender> getGetJavaMailSenderInstanceSupplier() {
    return BeanInstanceSupplier.<JavaMailSender>forFactoryMethod(EmailConfig.class, "getJavaMailSender")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(EmailConfig.class).getJavaMailSender());
  }

  /**
   * Get the bean definition for 'getJavaMailSender'.
   */
  public static BeanDefinition getGetJavaMailSenderBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(JavaMailSender.class);
    beanDefinition.setInstanceSupplier(getGetJavaMailSenderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'factoryBean'.
   */
  private static BeanInstanceSupplier<FreeMarkerConfigurationFactoryBean> getFactoryBeanInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FreeMarkerConfigurationFactoryBean>forFactoryMethod(EmailConfig.class, "factoryBean")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(EmailConfig.class).factoryBean());
  }

  /**
   * Get the bean definition for 'factoryBean'.
   */
  public static BeanDefinition getFactoryBeanBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(FreeMarkerConfigurationFactoryBean.class);
    beanDefinition.setPrimary(true);
    beanDefinition.setInstanceSupplier(getFactoryBeanInstanceSupplier());
    return beanDefinition;
  }
}
