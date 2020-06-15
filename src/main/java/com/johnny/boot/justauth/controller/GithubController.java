package com.johnny.boot.justauth.controller;

import com.johnny.boot.justauth.utils.AuthUtils;
import me.zhyd.oauth.model.AuthCallback;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.request.AuthRequest;
import me.zhyd.oauth.utils.AuthStateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Github 登录
 *
 * @author johnny
 * @create 2020-06-15 下午2:27
 **/
@RestController
public class GithubController {

    /**
     * 重定向到 Github 登录界面
     * @param response
     * @throws IOException
     */
    //@RequestMapping("/render")
    public void renderAuth(HttpServletResponse response) throws IOException {
        AuthRequest authRequest = AuthUtils.getGithubRequest();
        response.sendRedirect(authRequest.authorize(AuthStateUtils.createState()));
    }

    /**
     * 登录 获取QQ用户信息
     * 保存到数据库 和 本地用户管理进行绑定
     */
    //@RequestMapping("/auth/{source}")
    public Object login(@PathVariable("source") String source, AuthCallback callback) {
        AuthRequest authRequest = AuthUtils.getGithubRequest();
        AuthResponse response = authRequest.login(callback);
        return response;
    }

}