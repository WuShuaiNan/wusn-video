package com.wusn.video.stack.cache;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;
import com.wusn.video.stack.bean.entity.RTSP;

/**
 * RTSP 缓存。
 *
 * @author wusn
 * @since 1.0.0
 */
public interface RTSPCache extends BatchBaseCache<LongIdKey, RTSP> {
}
