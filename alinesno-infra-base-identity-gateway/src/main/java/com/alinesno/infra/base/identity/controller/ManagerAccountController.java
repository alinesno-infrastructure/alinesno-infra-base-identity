package com.alinesno.infra.base.identity.controller;

import com.alinesno.infra.base.identity.entity.RegisteredAppEntity;
import com.alinesno.infra.base.identity.service.IRegisteredAppService;
import com.alinesno.infra.common.core.constants.SpringInstanceScope;
import com.alinesno.infra.common.facade.pageable.DatatablesPageBean;
import com.alinesno.infra.common.facade.pageable.TableDataInfo;
import com.alinesno.infra.common.web.adapter.rest.BaseController;
import io.swagger.annotations.Api;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户管理角色
 *
 * @version 1.0.0
 * @author luoxiaodong
 */
@Api(tags = "GrantType")
@RestController
@Slf4j
@Scope(SpringInstanceScope.PROTOTYPE)
@RequestMapping("/api/infra/base/identity/managerAccount")
public class ManagerAccountController extends BaseController<RegisteredAppEntity, IRegisteredAppService> {

    @Autowired
    private IRegisteredAppService service;

    /**
     * 获取RegisteredAppEntity的DataTables数据。
     *
     * @param request HttpServletRequest对象。
     * @param model Model对象。
     * @param page DatatablesPageBean对象。
     * @return 包含DataTables数据的TableDataInfo对象。
     */
    @ResponseBody
    @PostMapping("/datatables")
    public TableDataInfo datatables(HttpServletRequest request, Model model, DatatablesPageBean page) {
        log.debug("page = {}", ToStringBuilder.reflectionToString(page));
        return this.toPage(model, this.getFeign(), page);
    }

    @Override
    public IRegisteredAppService getFeign() {
        return this.service;
    }

}
