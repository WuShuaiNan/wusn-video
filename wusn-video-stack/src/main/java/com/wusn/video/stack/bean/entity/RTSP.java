package com.wusn.video.stack.bean.entity;

import com.dwarfeng.subgrade.stack.bean.entity.Entity;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;

/**
 * RTSP 实体。
 *
 * @author wusn
 * @since 1.0.0
 */
public class RTSP implements Entity<LongIdKey> {

    private LongIdKey key;
    private String label;
    private String url;
    private String remark;

    public RTSP() {
    }

    public RTSP(LongIdKey key, String label, String url, String remark) {
        this.key = key;
        this.label = label;
        this.url = url;
        this.remark = remark;
    }

    @Override
    public LongIdKey getKey() {
        return key;
    }

    public void setKey(LongIdKey key) {
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
        return "RTSP{" +
                "key=" + key +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
