package helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/browserstack/app.properties"
})
public interface AppConfig extends Config {

    String webUrl();
    String userLogin();
    String userKey();
    String userApp();
    String remoteUrl();
    String localUrl();
    String mobileName();
}
