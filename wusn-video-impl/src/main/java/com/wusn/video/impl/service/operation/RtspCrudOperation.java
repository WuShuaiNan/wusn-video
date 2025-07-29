package com.wusn.video.impl.service.operation;

import com.dwarfeng.subgrade.sdk.exception.ServiceExceptionCodes;
import com.dwarfeng.subgrade.sdk.service.custom.operation.BatchCrudOperation;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.ServiceException;
import com.wusn.video.stack.bean.entity.Rtsp;
import com.wusn.video.stack.cache.RtspCache;
import com.wusn.video.stack.dao.RtspDao;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RtspCrudOperation implements BatchCrudOperation<LongIdKey, Rtsp> {

    private final RtspDao rtspDao;
    private final RtspCache rtspCache;

    @Value("${cache.timeout.entity.rtsp}")
    private long RTSPTimeout;

    public RtspCrudOperation(
            RtspDao rtspDao, RtspCache rtspCache
    ) {
        this.rtspDao = rtspDao;
        this.rtspCache = rtspCache;
    }

    @Override
    public boolean exists(LongIdKey key) throws Exception {
        return rtspCache.exists(key) || rtspDao.exists(key);
    }

    @Override
    public Rtsp get(LongIdKey key) throws Exception {
        if (rtspCache.exists(key)) {
            return rtspCache.get(key);
        } else {
            if (!rtspDao.exists(key)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            Rtsp rtsp = rtspDao.get(key);
            rtspCache.push(rtsp, RTSPTimeout);
            return rtsp;
        }
    }

    @Override
    public LongIdKey insert(Rtsp rtsp) throws Exception {
        rtspCache.push(rtsp, RTSPTimeout);
        return rtspDao.insert(rtsp);
    }

    @Override
    public void update(Rtsp rtsp) throws Exception {
        rtspCache.push(rtsp, RTSPTimeout);
        rtspDao.update(rtsp);
    }

    @Override
    public void delete(LongIdKey key) throws Exception {
        // 删除账本实体自身。
        rtspCache.delete(key);
        rtspDao.delete(key);
    }

    @Override
    public boolean allExists(List<LongIdKey> keys) throws Exception {
        return rtspCache.allExists(keys) || rtspDao.allExists(keys);
    }

    @Override
    public boolean nonExists(List<LongIdKey> keys) throws Exception {
        return rtspCache.nonExists(keys) && rtspDao.nonExists(keys);
    }

    @Override
    public List<Rtsp> batchGet(List<LongIdKey> keys) throws Exception {
        if (rtspCache.allExists(keys)) {
            return rtspCache.batchGet(keys);
        } else {
            if (!rtspDao.allExists(keys)) {
                throw new ServiceException(ServiceExceptionCodes.ENTITY_NOT_EXIST);
            }
            List<Rtsp> rtsps = rtspDao.batchGet(keys);
            rtspCache.batchPush(rtsps, RTSPTimeout);
            return rtsps;
        }
    }

    @Override
    public List<LongIdKey> batchInsert(List<Rtsp> rtsps) throws Exception {
        rtspCache.batchPush(rtsps, RTSPTimeout);
        return rtspDao.batchInsert(rtsps);
    }

    @Override
    public void batchUpdate(List<Rtsp> rtsps) throws Exception {
        rtspCache.batchPush(rtsps, RTSPTimeout);
        rtspDao.batchUpdate(rtsps);
    }

    @Override
    public void batchDelete(List<LongIdKey> keys) throws Exception {
        for (LongIdKey key : keys) {
            delete(key);
        }
    }
}
