package com.johnny.boot.justauth.utils;

import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthGithubRequest;
import me.zhyd.oauth.request.AuthQqRequest;
import me.zhyd.oauth.request.AuthRequest;

/**
 * @author johnny
 * @create 2020-06-15 上午10:36
 **/
public class AuthUtils {


    public static AuthRequest getQQAuthRequest() {
        return new AuthQqRequest(AuthConfig.builder()
                .clientId("101841802")
                .clientSecret("cb3435edc104a10ef7bca8904c2ff4ca")
                .redirectUri("http://www.askajohnny.com/blogs/auth/qq")
                .build());
    }


    public static AuthRequest getGithubRequest(){
        return new AuthGithubRequest(AuthConfig.builder()
                .clientId("b28eb51f9f9cb8592e8b")
                .clientSecret("9d05fd5c5a2d3024ade8d617fbaf987ab1990246")
                .redirectUri("http://www.askajohnny.com/blogs/auth/github")
                .build());
    }
}