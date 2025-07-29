package com.wusn.video.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.subgrade.sdk.bean.key.JSFixedFastJsonLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import com.wusn.video.stack.bean.entity.Rtsp;

import java.util.Objects;

/**
 * JSFixed FastJson Rtsp。
 *
 * @author wusn
 * @since 1.0.1
 */
public class JSFixedFastJsonRtsp implements Bean {

    private static final long serialVersionUID = 1180296029944096307L;

    public static JSFixedFastJsonRtsp of(Rtsp rtsp) {
        if (Objects.isNull(rtsp)) {
            return null;
        } else {
            return new JSFixedFastJsonRtsp(
                    JSFixedFastJsonLongIdKey.of(rtsp.getKey()),
                    rtsp.getLabel(),
                    rtsp.getUrl(),
                    rtsp.getRemark()
            );
        }
    }

    @JSONField(name = "key", ordinal = 1)
    private JSFixedFastJsonLongIdKey key;

    @JSONField(name = "label", ordinal = 2)
    private String label;

    @JSONField(name = "url", ordinal = 3)
    private String url;

    @JSONField(name = "remark", ordinal = 4)
    private String remark;

    public JSFixedFastJsonRtsp() {
    }

    public JSFixedFastJsonRtsp(JSFixedFastJsonLongIdKey key, String label, String url, String remark) {
        this.key = key;
        this.label = label;
        this.url = url;
        this.remark = remark;
    }

    public JSFixedFastJsonLongIdKey getKey() {
        return key;
    }

    public void setKey(JSFixedFastJsonLongIdKey key) {
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
        return "JSFixedFastJsonRtsp{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
