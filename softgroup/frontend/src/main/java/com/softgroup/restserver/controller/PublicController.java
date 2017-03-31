package com.softgroup.restserver.controller;

import com.softgroup.authorization.api.message.RegisterResponse;
import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.firstrouter.api.RequestRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 20.03.2017.
 */
@RestController
@RequestMapping(
        value = "/"
        ,headers = {"command=register"}
        )
public class PublicController {

    @Autowired
    RequestRouter requestRouter;
    @Autowired
    Environment environment;

    @RequestMapping(

            consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> registration(
            @RequestBody Request<?> request
            ){
        String strCommand = request.getHeader().getCommand();

        Response<?> response = requestRouter.handle(request);
        RegisterResponse registerResponse = (RegisterResponse) response.retData(response);

        HttpHeaders headers = new HttpHeaders();
        headers.add("command","register");
        headers.add("xToken",registerResponse.getAuthCode());

        ResponseEntity<?> responseEntity  = new ResponseEntity<>(
                registerResponse
                ,headers
                , HttpStatus.OK
        );
        return responseEntity;
    }
}
