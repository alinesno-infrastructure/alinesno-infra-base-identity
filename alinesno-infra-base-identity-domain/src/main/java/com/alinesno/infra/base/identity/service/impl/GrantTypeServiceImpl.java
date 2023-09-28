package com.alinesno.infra.base.identity.service.impl;

import com.alinesno.infra.base.identity.entity.GrantTypeEntity;
import com.alinesno.infra.base.identity.mapper.GrantTypeMapper;
import com.alinesno.infra.base.identity.service.IGrantTypeService;
import com.alinesno.infra.common.core.service.impl.IBaseServiceImpl;
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
@Service
public class GrantTypeServiceImpl extends IBaseServiceImpl<GrantTypeEntity, GrantTypeMapper> implements IGrantTypeService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(GrantTypeServiceImpl.class);

}