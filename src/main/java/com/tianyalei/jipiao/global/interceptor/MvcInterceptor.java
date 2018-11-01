package com.tianyalei.jipiao.global.interceptor;

import com.tianyalei.jipiao.ApplicationContextProvider;
import com.tianyalei.jipiao.global.cache.UserCache;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author wuweifeng wrote on 2017/10/27.
 */
public class MvcInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token");
        if (request.getRequestURI().contains("login")) {
            return true;
        }
        //没token，或token在缓存中找不到
        if (token == null || ApplicationContextProvider.getBean(UserCache.class).findUserByToken(token) ==
                null) {
            gotoLogin(response);
            return false;
        }

        return true;
    }

    private void gotoLogin(HttpServletResponse httpResponse) throws IOException {
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("{\"code\":403, \"message\":\"no login\"}");
    }
}
