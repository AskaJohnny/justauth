package com.johnny.boot.justauth.controller;

import com.johnny.boot.justauth.utils.AuthUtils;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author johnny
 * @create 2020-06-15 上午10:32
 **/
@RestController
public class QQAuthController {

    /**
     * 重定向到 QQ登录界面
     *
     * @param response
     * @throws IOException
     */
    @RequestMapping("/render")
    @CrossOrigin
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = AuthUtils.getQQAuthRequest();
        response.sendRedirect(authRequest.authorize(AuthStateUtils.createState()));
    }

    /**
     * 获取到 跳转到QQ登录的 URL 供前端 进行跳转，前端可以通过iframe 或者 模态框进行 展示页面
     * 前后端分离项目
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/renderUrl")
    @CrossOrigin
    public String getRenderUrl(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = AuthUtils.getQQAuthRequest();
        return authRequest.authorize(AuthStateUtils.createState());
    }

    /**
     * 登录 获取QQ用户信息
     * 保存到数据库 和 本地用户管理进行绑定
     */
    @RequestMapping("/auth/{source}")
    public Object login(@PathVariable("source") String source, AuthCallback callback) {
        AuthRequest authRequest = AuthUtils.getQQAuthRequest();
        AuthResponse response = authRequest.login(callback);
        return response;
    }

    @RequestMapping("/refresh")
    public Object refreshToken() {
        AuthRequest authRequest = AuthUtils.getQQAuthRequest();
        AuthResponse response = authRequest.refresh(AuthToken.builder().refreshToken("2741209DAF412423FF51531C9BB1250A").build());
        return response;
    }


}