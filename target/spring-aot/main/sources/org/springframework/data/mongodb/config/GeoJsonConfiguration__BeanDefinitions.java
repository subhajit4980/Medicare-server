package org.springframework.data.mongodb.config;

import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.data.mongodb.core.geo.GeoJsonModule;

/**
 * Bean definitions for {@link GeoJsonConfiguration}.
 */
public class GeoJsonConfiguration__BeanDefinitions {
  /**
   * Get the bean definition for 'geoJsonConfiguration'.
   */
  public static BeanDefinition getGeoJsonConfigurationBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition(GeoJsonConfiguration.class);
    beanDefinition.setInstanceSupplier(GeoJsonConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'geoJsonModule'.
   */
  private static BeanInstanceSupplier<GeoJsonModule> getGeoJsonModuleInstanceSupplier() {
    return BeanInstanceSupplier.<GeoJsonModule>forFactoryMethod(GeoJsonConfiguration.class, "geoJsonModule")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(GeoJsonConfiguration.class).geoJsonModule());
  }

  /**
   * Get the bean definition for 'geoJsonModule'.
   */
  public static BeanDefinition getGeoJsonModuleBeanDefinition() {
    RootBeanDefinition beanDefinition = new RootBeanDefinition();
    beanDefinition.setTargetType(GeoJsonModule.class);
    beanDefinition.setInstanceSupplier(getGeoJsonModuleInstanceSupplier());
    return beanDefinition;
  }
}
