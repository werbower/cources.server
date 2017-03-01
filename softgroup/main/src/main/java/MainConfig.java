import com.softgroup.authorization.api.AuthorizationConfig;
import com.softgroup.common.router.api.RouterConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Created by user on 01.03.2017.
 */
@Configuration
@Import({RouterConfig.class, AuthorizationConfig.class})

public class MainConfig {
}
