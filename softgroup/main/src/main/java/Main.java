import com.softgroup.authorization.api.message.AuthorizationRequest;
import com.softgroup.authorization.api.message.LoginRequest;
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

        RouterHandler authorizationRouter = new AuthorizationRouter();

        Map<String,Handler> mapRH = new HashMap<>();
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


        return resList;



    }

}
