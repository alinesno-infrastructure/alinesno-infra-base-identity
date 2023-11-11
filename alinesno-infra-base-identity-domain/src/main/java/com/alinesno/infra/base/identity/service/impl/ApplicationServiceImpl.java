package com.alinesno.infra.base.identity.service.impl;

import com.alinesno.infra.base.identity.entity.ApplicationEntity;
import com.alinesno.infra.base.identity.entity.GrantTypeEntity;
import com.alinesno.infra.base.identity.mapper.ApplicationMapper;
import com.alinesno.infra.base.identity.mapper.GrantTypeMapper;
import com.alinesno.infra.base.identity.service.IApplicationService;
import com.alinesno.infra.base.identity.service.IGrantTypeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ApplicationServiceImpl extends IBaseServiceImpl<ApplicationEntity, ApplicationMapper> implements IApplicationService {


}