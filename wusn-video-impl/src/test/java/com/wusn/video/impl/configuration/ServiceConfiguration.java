package com.wusn.video.impl.configuration;

import com.dwarfeng.sfds.api.integration.subgrade.SnowFlakeLongIdKeyFetcher;
import com.dwarfeng.subgrade.impl.bean.key.ExceptionKeyFetcher;
import com.dwarfeng.subgrade.impl.service.CustomBatchCrudService;
import com.dwarfeng.subgrade.impl.service.DaoOnlyEntireLookupService;
import com.dwarfeng.subgrade.stack.bean.key.KeyFetcher;
import com.dwarfeng.subgrade.stack.bean.key.LongIdKey;
import com.dwarfeng.subgrade.stack.log.LogLevel;
import com.wusn.video.impl.service.operation.RtspCrudOperation;
import com.wusn.video.stack.bean.entity.Rtsp;
import com.wusn.video.stack.dao.RtspDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    private final ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration;

    private final RtspCrudOperation rtspCrudOperation;
    private final RtspDao rtspDao;


    public ServiceConfiguration(
            ServiceExceptionMapperConfiguration serviceExceptionMapperConfiguration,
            RtspCrudOperation rtspCrudOperation,
            RtspDao rtspDao
    ) {
        this.serviceExceptionMapperConfiguration = serviceExceptionMapperConfiguration;
        this.rtspCrudOperation = rtspCrudOperation;
        this.rtspDao = rtspDao;
    }

    @Bean
    public KeyFetcher<LongIdKey> longIdKeyKeyFetcher() {
        return new SnowFlakeLongIdKeyFetcher();
    }

    @Bean
    public CustomBatchCrudService<LongIdKey, Rtsp> rtspBatchCustomCrudService() {
        return new CustomBatchCrudService<>(
                rtspCrudOperation,
                new ExceptionKeyFetcher<>(),
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

    @Bean
    public DaoOnlyEntireLookupService<Rtsp> rtspDaoOnlyEntireLookupService() {
        return new DaoOnlyEntireLookupService<>(
                rtspDao,
                serviceExceptionMapperConfiguration.mapServiceExceptionMapper(),
                LogLevel.WARN
        );
    }

}
