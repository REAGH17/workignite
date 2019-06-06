import org.apache.ignite.configuration.IgniteConfiguration;

/**
 * Created by 2 on 06.06.2019.
 */
public class Config {
    static IgniteConfiguration configuration(boolean isClient) {
        IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
        igniteConfiguration.setClientMode(isClient);
        igniteConfiguration.setLocalHost("127.0.0.1");
        return igniteConfiguration;
    }
}

