package sarfwebservice;

import com.google.inject.Injector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.guice.annotation.EnableGuiceModules;
import sarf.SarfDictionary;
import sarf.SarfModule;

@Configuration
@EnableGuiceModules
public class GuiceBridgeConfiguration {

    @Autowired
    public Injector injector;

    @Bean
    public SarfModule sarfModule(){
        return new SarfModule();
    }
}
