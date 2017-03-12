package com.softgroup.main.test;

import com.softgroup.common.protocol.ActionHeader;
import com.softgroup.common.protocol.Request;
import com.softgroup.firstrouter.api.RequestRouter;
import com.softgroup.main.MainConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by Odin on 01.03.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RequestRouterIT.LessonRouterTestCfg.class})
public class RequestRouterIT {

    @Autowired
    private RequestRouter requestRouter;

    @Test
    public void testRoute(){
        String curType ="authorization";

        Request<?> request = new Request<>();
        ActionHeader header = new ActionHeader();
        header.setType(curType);
        request.setHeader(header);
        //


        assertEquals(requestRouter.getMap().get(curType).getName(),curType);
    }


    @Configuration
    @Import(MainConfig.class)
    public static class LessonRouterTestCfg {


    }
}
