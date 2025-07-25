package com.wusn.video.impl.bean;

import com.dwarfeng.subgrade.sdk.bean.key.HibernateLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.HibernateStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.wusn.video.impl.bean.entity.HibernateRTSP;
import com.wusn.video.stack.bean.entity.RTSP;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Hibernate Bean 映射器。
 *
 * @author wusn
 * @since 1.0.0
 */
@Mapper
public interface HibernateMapper {

    // 常规映射
    HibernateLongIdKey longIdKeyToHibernate(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromHibernate(HibernateLongIdKey hibernateLongIdKey);

    HibernateStringIdKey stringIdKeyToHibernate(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromHibernate(HibernateStringIdKey hibernateStringIdKey);


    // 自定义映射
    @Mapping(target = "longId", ignore = true)
    HibernateRTSP rtspToHibernate(RTSP rtsp);

    @InheritInverseConfiguration
    RTSP rtspFromHibernate(HibernateRTSP hibernateRTSP);
}
