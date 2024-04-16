package com.alinesno.infra.base.identity.service.impl;

import com.alinesno.infra.base.identity.entity.LoginSettingEntity;
import com.alinesno.infra.base.identity.mapper.LoginSettingMapper;
import com.alinesno.infra.base.identity.service.ILoginSettingService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author WeiXiaoJin
 * @version 1.0.0
 */
@Slf4j
@Service
public class LoginSettingServiceImpl extends IBaseServiceImpl<LoginSettingEntity, LoginSettingMapper> implements ILoginSettingService {

}