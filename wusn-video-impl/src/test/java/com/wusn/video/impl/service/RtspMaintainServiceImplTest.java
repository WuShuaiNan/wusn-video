package com.wusn.video.impl.service;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.wusn.video.stack.bean.entity.Rtsp;
import com.wusn.video.stack.service.RtspMaintainService;
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
public class RtspMaintainServiceImplTest {

    @Autowired
    private RtspMaintainService rtspMaintainService;

    private List<Rtsp> rtsps;

    @Before
    public void setUp() {
        rtsps = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Rtsp rtsp = new Rtsp(new LongIdKey(i), "label", "url",  "remark");
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
            for (Rtsp rtsp : rtsps) {
                rtspMaintainService.insertOrUpdate(rtsp);

                Rtsp testRtsp = rtspMaintainService.get(rtsp.getKey());
                assertEquals(BeanUtils.describe(rtsp), BeanUtils.describe(testRtsp));
                rtspMaintainService.update(rtsp);
                testRtsp = rtspMaintainService.get(rtsp.getKey());
                assertEquals(BeanUtils.describe(rtsp), BeanUtils.describe(testRtsp));
            }
        } finally {
            for (Rtsp rtsp : rtsps) {
                rtspMaintainService.deleteIfExists(rtsp.getKey());
            }
        }
    }
}
