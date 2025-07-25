package com.wusn.video.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import com.wusn.video.stack.bean.entity.RTSP;

import java.util.Objects;

/**
 * FastJson RTSP。
 *
 * @author wusn
 *
 * @since 1.0.0
 */
public class FastJsonRTSP implements Bean {

    private static final long serialVersionUID = 4047626256519104468L;

    public static FastJsonRTSP of(RTSP rtsp) {
        if (Objects.isNull(rtsp)) {
            return null;
        } else {
            return new FastJsonRTSP(
                    FastJsonLongIdKey.of(rtsp.getKey()),
                    rtsp.getLabel(),
                    rtsp.getUrl(),
                    rtsp.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private FastJsonLongIdKey key;

    @JSONField(name = "label", ordinal = 2)
    private String label;

    @JSONField(name = "url", ordinal = 3)
    private String url;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    public FastJsonRTSP() {
    }

    public FastJsonRTSP(FastJsonLongIdKey key, String label, String url, String remark) {
        this.key = key;
        this.label = label;
        this.url = url;
        this.remark = remark;
    }

    public FastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(FastJsonLongIdKey key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FastJsonRTSP{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
