package com.wusn.video.impl.service;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.wusn.video.stack.bean.entity.RTSP;
import com.wusn.video.stack.service.RTSPMaintainService;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/application-context*.xml")
public class RTSPMaintainServiceImplTest {

    @Autowired
    private RTSPMaintainService rtspMaintainService;

    private List<RTSP> rtsps;

    @Before
    public void setUp() {
        rtsps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            RTSP rtsp = new RTSP(new LongIdKey(i), "label", "url",  "remark");
            rtsps.add(rtsp);
        }
    }

    @After
    public void tearDown() {
        rtsps.clear();
    }

    @Test
    public void testForCrud() throws Exception {
        try {
            for (RTSP rtsp : rtsps) {
                rtspMaintainService.insertOrUpdate(rtsp);

                RTSP testRTSP = rtspMaintainService.get(rtsp.getKey());
                assertEquals(BeanUtils.describe(rtsp), BeanUtils.describe(testRTSP));
                rtspMaintainService.update(rtsp);
                testRTSP = rtspMaintainService.get(rtsp.getKey());
                assertEquals(BeanUtils.describe(rtsp), BeanUtils.describe(testRTSP));
            }
        } finally {
            for (RTSP rtsp : rtsps) {
                rtspMaintainService.deleteIfExists(rtsp.getKey());
            }
        }
    }
}
