package com.wusn.video.sdk.util;

/**
 * 约束类。
 *
 * @author wusn
 * @since 1.0.0
 */
public final class Constraints {

    /**
     * 名称的长度约束。
     */
    public static final int LENGTH_NAME = 20;

    /**
     * 备注的长度约束。
     */
    public static final int LENGTH_REMARK = 100;

    /**
     * 主键的长度约束。
     */
    public static final int LENGTH_ID = 50;

    private Constraints() {
        throw new IllegalStateException("禁止实例化");
    }
}
