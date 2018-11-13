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
        String userId = request.getHeader("userId");
        if (request.getRequestURI().contains("login") || request.getRequestURI().contains("error")) {
            return true;
        }
        //TODO 待删除
        //if (userId == null) {
        //    userId = "a";
        //    ApplicationContextProvider.getBean(UserCache.class).saveUserId(userId, "a");
        //}
        String userName = ApplicationContextProvider.getBean(UserCache.class).findNameByUserId(userId);
        //没token，或token在缓存中找不到
        if (userId == null || userName == null) {
            gotoLogin(response);
            return false;
        }

        request.setAttribute("userId", userId);
        request.setAttribute("userName", userName);
        return true;
    }

    private void gotoLogin(HttpServletResponse httpResponse) throws IOException {
        httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        httpResponse.getWriter().write("{\"code\":403, \"message\":\"no login\"}");
    }
}
