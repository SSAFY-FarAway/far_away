package com.ssafy.faraway.common.interceptor;

import com.ssafy.faraway.domain.member.dto.res.MemberLoginResponseDto;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean result = false;

        HttpSession session = request.getSession();
        MemberLoginResponseDto loginMember = (MemberLoginResponseDto) session.getAttribute("loginMember");
        if (loginMember == null) {
            if(isAjaxRequest(request)) {
                try {
                    response.sendError(400);
                    result = false;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    response.sendRedirect(request.getContextPath() + "/login");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else
            result = true;
        return result;
    }

    private boolean isAjaxRequest(HttpServletRequest req) {
        String header = req.getHeader("AJAX");
        if ("true".equals(header)) {
            return true;
        } else {
            return false;
        }
    }
}
