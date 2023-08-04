package com.alinesno.infra.base.identity.service.impl;

import com.alinesno.infra.base.identity.entity.WhiteAccountStatusEntity;
import com.alinesno.infra.base.identity.mapper.WhiteAccountStatusMapper;
import com.alinesno.infra.base.identity.service.IWhiteAccountStatusService;
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
public class WhiteAccountStatusServiceImpl extends IBaseServiceImpl<WhiteAccountStatusEntity, WhiteAccountStatusMapper> implements IWhiteAccountStatusService {

	// 日志记录
	@SuppressWarnings("unused")
	private static final Logger log = LoggerFactory.getLogger(WhiteAccountStatusServiceImpl.class);

}