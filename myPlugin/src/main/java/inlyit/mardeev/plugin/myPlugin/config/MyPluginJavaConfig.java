package inlyit.mardeev.plugin.myPlugin.config;

import com.atlassian.plugins.osgi.javaconfig.configs.beans.ModuleFactoryBean;
import com.atlassian.plugins.osgi.javaconfig.configs.beans.PluginAccessorBean;
import com.atlassian.sal.api.ApplicationProperties;
import inlyit.mardeev.plugin.myPlugin.api.MyPluginComponent;
import inlyit.mardeev.plugin.myPlugin.impl.MyPluginComponentImpl;
import inlyit.mardeev.plugin.myPlugin.service.MyPluginService;
import inlyit.mardeev.plugin.myPlugin.servlet.MyPluginServlet;
import org.osgi.framework.ServiceRegistration;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import static com.atlassian.plugins.osgi.javaconfig.OsgiServices.exportOsgiService;
import static com.atlassian.plugins.osgi.javaconfig.OsgiServices.importOsgiService;

@Configuration
@Import({
        ModuleFactoryBean.class,
        PluginAccessorBean.class
})
public class MyPluginJavaConfig {


    // imports ApplicationProperties from OSGi
    @Bean
    public ApplicationProperties applicationProperties() {
        return importOsgiService(ApplicationProperties.class);
    }

    @Bean
    public MyPluginComponent myPluginComponent(ApplicationProperties applicationProperties) {
        return new MyPluginComponentImpl(applicationProperties);
    }

    @Bean
    public MyPluginService myPluginService() {
        return new MyPluginService();
    }

    @Bean
    public MyPluginServlet myPluginServlet(MyPluginService myPluginService) {
        return new MyPluginServlet(myPluginService);
    }

    // Exports MyPluginComponent as an OSGi service
    @Bean
    public FactoryBean<ServiceRegistration> registerMyDelegatingService(
            final MyPluginComponent mypluginComponent) {
        return exportOsgiService(mypluginComponent, null, MyPluginComponent.class);
    }

}