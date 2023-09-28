package com.alinesno.infra.base.identity.auth.controller;

import cn.hutool.core.codec.Base64;
import com.alinesno.infra.common.facade.response.AjaxResult;
import com.alinesno.infra.common.web.adapter.utils.IdUtils;
import com.google.code.kaptcha.Producer;
import jakarta.annotation.Resource;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 生成验证二维码
 */
@RestController
public class CaptchaController {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    public CaptchaController(Producer captchaProducer, Producer captchaProducerMath) {
        this.captchaProducer = captchaProducer;
        this.captchaProducerMath = captchaProducerMath;
    }

    /**
     * 生成验证码
     */
    @GetMapping("/captchaImage")
    public AjaxResult captchaImage() throws IOException {
        AjaxResult ajax = AjaxResult.success();

        // 保存验证码信息
        String uuid = IdUtils.simpleUUID();

        String capStr;
        BufferedImage image;

        // 生成验证码
        String capText = captchaProducerMath.createText();
        capStr = capText.substring(0, capText.lastIndexOf("@"));
        image = captchaProducerMath.createImage(capStr);

        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        try {
            ImageIO.write(image, "jpg", os);
        } catch (IOException e) {
            return AjaxResult.error(e.getMessage());
        }

        ajax.put("uuid", uuid);
        ajax.put("img", Base64.encode(os.toByteArray()));

        return ajax;
    }
}