package com.softgroup.restserver.controller;

import com.softgroup.common.protocol.Request;
import com.softgroup.common.protocol.Response;
import com.softgroup.firstrouter.api.RequestRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by user on 20.03.2017.
 */
@RestController
@RequestMapping(
        value = "/messager"
        )
public class PrivateController {

    @Autowired
    RequestRouter firstRouter;

    @RequestMapping(

            consumes = MediaType.APPLICATION_JSON_VALUE
            ,produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Response<?>> registration(@RequestBody Request<?> request ){
        request.getHeader().setOriginUuid(request.getHeader().getUuid());
        request.getHeader().setUuid((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return new ResponseEntity<>(firstRouter.handle(request),HttpStatus.OK);
    }
}
