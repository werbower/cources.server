import com.softgroup.authorization.api.message.AuthorizationRequest;
import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.common.protocol.Request;
import com.softgroup.firstrouter.api.RequestRouter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 01.03.2017.
 */
public class MainSpring {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);


        RequestRouter requestRouter = context.getBean(RequestRouter.class);
        List<Request<?>> requestList = createRequestList();
        for (Request<?> request: requestList) {
            requestRouter.handle(request);
        }

    }
    public static List<Request<?>> createRequestList(){
        List<Request<?>> resList = new ArrayList<>();

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setDeviceToken("дайте логина");
        Request<LoginRequest> requestLoginRequest = new AuthorizationRequest<>();
        requestLoginRequest.getHeader().setCommand("login");
        requestLoginRequest.setData(loginRequest);
        resList.add(requestLoginRequest);

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setDeviceId("ид регистрации");
        registerRequest.setLocaleCode("код локали");
        registerRequest.setPhoneNumber("телефонный номер");

        Request<RegisterRequest> requestRegisterRequest = new AuthorizationRequest<>();
        requestRegisterRequest.getHeader().setCommand("register");
        requestRegisterRequest.setData(registerRequest);
        resList.add(requestRegisterRequest);


        return resList;



    }
}
