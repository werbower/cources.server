package com.softgroup.profileservice.router;

import com.softgroup.common.router.api.implementation.HandlerRouter;
import com.softgroup.common.router.api.interfaces.ProfileHandler;
import com.softgroup.common.router.api.interfaces.RouterHandler;
import org.springframework.stereotype.Component;

/**
 * Created by user on 27.02.2017.
 */
@Component
public class ProfileRouter extends HandlerRouter<ProfileHandler> implements RouterHandler {


    public String getName() {
        return "profile";
    }





}
