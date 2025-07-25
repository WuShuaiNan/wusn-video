package com.wusn.video.sdk.bean.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.dwarfeng.subgrade.sdk.bean.key.WebInputLongIdKey;
import com.dwarfeng.subgrade.stack.bean.Bean;
import com.wusn.video.stack.bean.entity.RTSP;

import java.util.Objects;

/**
 * WebInput rtsp。
 *
 * @author wusn
 * @since 1.0.0
 */
public class WebInputRTSP implements Bean {

    public static RTSP toStackBean(WebInputRTSP webInputRTSP) {
        if (Objects.isNull(webInputRTSP)) {
            return null;
        } else {
            return new RTSP(
                    WebInputLongIdKey.toStackBean(webInputRTSP.getKey()),
                    webInputRTSP.getLabel(),
                    webInputRTSP.getUrl(),
                    webInputRTSP.getRemark()
            );
        }
    }

    @JSONField(name = "key")
    private WebInputLongIdKey key;

    @JSONField(name = "label")
    private String label;

    @JSONField(name = "url")
    private String url;

    @JSONField(name = "remark")
    private String remark;

    public WebInputRTSP() {
    }

    public WebInputRTSP(WebInputLongIdKey key, String label, String url, String remark) {
        this.key = key;
        this.label = label;
        this.url = url;
        this.remark = remark;
    }

    public WebInputLongIdKey getKey() {
        return key;
    }

    public void setKey(WebInputLongIdKey key) {
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
        return "WebInputRTSP{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
