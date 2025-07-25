package com.wusn.video.node.configuration;


import com.dwarfeng.subgrade.impl.bean.MapStructBeanTransformer;
import com.dwarfeng.subgrade.impl.cache.RedisBatchBaseCache;
import com.dwarfeng.subgrade.sdk.redis.formatter.LongIdStringKeyFormatter;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.wusn.video.sdk.bean.FastJsonMapper;
import com.wusn.video.sdk.bean.entity.FastJsonRTSP;
import com.wusn.video.stack.bean.entity.RTSP;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class CacheConfiguration {

    private final RedisTemplate<String, ?> template;

    @Value("${cache.prefix.entity.rtsp}")
    private String rtspPrefix;

    public CacheConfiguration(RedisTemplate<String, ?> template) {
        this.template = template;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public RedisBatchBaseCache<LongIdKey, RTSP, FastJsonRTSP> rtspRedisBatchBaseCache() {
        return new RedisBatchBaseCache<>(
                (RedisTemplate<String, FastJsonRTSP>) template,
                new LongIdStringKeyFormatter(rtspPrefix),
                new MapStructBeanTransformer<>(RTSP.class, FastJsonRTSP.class, FastJsonMapper.class)
        );
    }

}
