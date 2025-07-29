package com.wusn.video.stack.dao;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.dao.BatchBaseDao;
import com.dwarfeng.subgrade.stack.dao.EntireLookupDao;
import com.wusn.video.stack.bean.entity.Rtsp;

/**
 * RTSP 数据访问层。
 *
 * @author wusn
 * @since 1.0.0
 */
public interface RtspDao extends BatchBaseDao<LongIdKey, Rtsp>, EntireLookupDao<Rtsp> {
}
