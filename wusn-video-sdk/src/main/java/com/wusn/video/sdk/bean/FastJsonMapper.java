package com.wusn.video.sdk.bean;

import com.dwarfeng.subgrade.sdk.bean.key.FastJsonLongIdKey;
import com.dwarfeng.subgrade.sdk.bean.key.FastJsonStringIdKey;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.bean.key.StringIdKey;
import com.wusn.video.sdk.bean.entity.FastJsonRTSP;
import com.wusn.video.stack.bean.entity.RTSP;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

/**
 * FastJson Bean 映射器。
 *
 * @author wusn
 * @since 1.0.0
 */
@Mapper
public interface FastJsonMapper {

    // 常规主键映射
    FastJsonLongIdKey longIdKeyToFastJson(LongIdKey longIdKey);

    @InheritInverseConfiguration
    LongIdKey longIdKeyFromFastJson(FastJsonLongIdKey fastJsonLongIdKey);

    FastJsonStringIdKey stringIdKeyToFastJson(StringIdKey stringIdKey);

    @InheritInverseConfiguration
    StringIdKey stringIdKeyFromFastJson(FastJsonStringIdKey fastJsonStringIdKey);

    // 自定义实体映射
    FastJsonRTSP rtspToFastJson(RTSP rtsp);

    @InheritInverseConfiguration
    RTSP rtspFromFastJson(FastJsonRTSP fastJsonRTSP);
}
