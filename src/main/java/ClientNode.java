import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.configuration.CacheConfiguration;

import java.time.LocalDate;

/**
 * Created by 2 on 06.06.2019.
 */
public class ClientNode {
    public static void main(String[] args) {
       try (Ignite ignite = Ignition.start(Config.configuration(true))){
           CacheConfiguration<String, User> userCacheConfiguration = new CacheConfiguration<>();
           userCacheConfiguration.setName("userCache");
           userCacheConfiguration.setCacheMode(CacheMode.PARTITIONED);
           userCacheConfiguration.setBackups(1);

           IgniteCache<String, User> userIgniteCache = ignite.getOrCreateCache(userCacheConfiguration);

           LocalDate date = LocalDate.of(2019, 1, 1);
           Company company = new Company("Sber", "1231241");
           userIgniteCache.put("test", new User("test", date, company));
           userIgniteCache.put("test1", new User("test1", date, company));
           userIgniteCache.put("test3", new User("test3", date, company));

           IgniteCompute igniteCompute = ignite.compute();
           igniteCompute.affinityRun("userCache","test", ()-> System.out.println(userIgniteCache.get("test")));
           igniteCompute.affinityRun("userCache","test1", ()-> System.out.println(userIgniteCache.get("test1")));
           igniteCompute.affinityRun("userCache","test3", ()-> System.out.println(userIgniteCache.get("test3")));
           //  System.out.println(userIgniteCache.get("test"));
       }

    }
}
