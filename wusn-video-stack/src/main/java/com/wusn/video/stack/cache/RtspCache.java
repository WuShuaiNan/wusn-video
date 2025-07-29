package com.wusn.video.stack.cache;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.cache.BatchBaseCache;
import com.wusn.video.stack.bean.entity.Rtsp;

/**
 * RTSP 缓存。
 *
 * @author wusn
 * @since 1.0.0
 */
public interface RtspCache extends BatchBaseCache<LongIdKey, Rtsp> {
}
