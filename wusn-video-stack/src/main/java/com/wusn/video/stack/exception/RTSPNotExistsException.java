package com.wusn.video.stack.exception;

import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.exception.HandlerException;

/**
 * RTSP 不存在异常。
 *
 * @author wusn
 * @since 1.0.0
 */
public class RTSPNotExistsException extends HandlerException {

    private static final long serialVersionUID = -5394896658989945556L;

    private final LongIdKey rtspKey;

    public RTSPNotExistsException(LongIdKey rtspKey) {
        this.rtspKey = rtspKey;
    }

    public RTSPNotExistsException(Throwable cause, LongIdKey rtspKey) {
        super(cause);
        this.rtspKey = rtspKey;
    }

    @Override
    public String getMessage() {
        return "rtsp流： " + rtspKey + " 不存在";
    }
}
