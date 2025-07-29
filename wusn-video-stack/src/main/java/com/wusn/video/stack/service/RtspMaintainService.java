package com.wusn.video.stack.service;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.service.BatchCrudService;
import com.dwarfeng.subgrade.stack.service.EntireLookupService;
import com.wusn.video.stack.bean.entity.Rtsp;

/**
 * RTSP 维护服务。
 *
 * @author wusn
 * @since 1.0.0
 */
public interface RtspMaintainService extends BatchCrudService<LongIdKey, Rtsp>, EntireLookupService<Rtsp> {
}
