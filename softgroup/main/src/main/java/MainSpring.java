import com.softgroup.common.router.api.implementation.RequestRouter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by user on 01.03.2017.
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);


        RequestRouter requestRouter = context.getBean(RequestRouter.class);

    }
}
