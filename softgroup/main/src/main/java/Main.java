import com.softgroup.authorization.api.message.AuthorizationRequest;
import com.softgroup.authorization.api.message.LoginRequest;
import com.softgroup.authorization.api.message.RegisterRequest;
import com.softgroup.authorization.api.router.AuthorizationRouter;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.router.api.implementation.RequestRouter;
import com.softgroup.common.router.api.interfaces.Handler;
import com.softgroup.common.router.api.interfaces.RouterHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by user on 27.02.2017.
 */
public class Main {
    public static void main(String[] args) {



        Map<String,Handler> mapRH = new HashMap<>();

        RouterHandler authorizationRouter = new AuthorizationRouter();
        mapRH.put(authorizationRouter.getName(),authorizationRouter);

        RequestRouter requestRouter = new RequestRouter();
        requestRouter.setMap(mapRH);

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
