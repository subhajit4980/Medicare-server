package org.springdoc.core.configuration;

import java.util.Optional;
import org.springdoc.core.converters.PageableOpenAPIConverter;
import org.springdoc.core.customizers.DelegatingMethodParameterCustomizer;
import org.springdoc.core.providers.ObjectMapperProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link SpringDocPageableConfiguration}.
 */
public class SpringDocPageableConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'springDocPageableConfiguration'.
   */
  public static BeanDefinition getSpringDocPageableConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(SpringDocPageableConfiguration.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(SpringDocPageableConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'pageableOpenAPIConverter'.
   */
  private static BeanInstanceSupplier<PageableOpenAPIConverter> getPageableOpenAPIConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<PageableOpenAPIConverter>forFactoryMethod(SpringDocPageableConfiguration.class, "pageableOpenAPIConverter", ObjectMapperProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocPageableConfiguration.class).pageableOpenAPIConverter(args.get(0)));
  }

  /**
   * Get the bean definition for 'pageableOpenAPIConverter'.
   */
  public static BeanDefinition getPageableOpenAPIConverterBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(PageableOpenAPIConverter.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getPageableOpenAPIConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'delegatingMethodParameterCustomizer'.
   */
  private static BeanInstanceSupplier<DelegatingMethodParameterCustomizer> getDelegatingMethodParameterCustomizerInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<DelegatingMethodParameterCustomizer>forFactoryMethod(SpringDocPageableConfiguration.class, "delegatingMethodParameterCustomizer", Optional.class, Optional.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(SpringDocPageableConfiguration.class).delegatingMethodParameterCustomizer(args.get(0), args.get(1)));
  }

  /**
   * Get the bean definition for 'delegatingMethodParameterCustomizer'.
   */
  public static BeanDefinition getDelegatingMethodParameterCustomizerBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(DelegatingMethodParameterCustomizer.class);
    beanDefinition.setLazyInit(false);
    beanDefinition.setInstanceSupplier(getDelegatingMethodParameterCustomizerInstanceSupplier());
    return beanDefinition;
  }
}
