import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.IgniteConfiguration;

/**
 * Created by 2 on 06.06.2019.
 */
public class ServerNode {
    public static void main(String[] args) {
        Ignition.start(Config.configuration(false));
    }
}
