package com.ssafy.faraway.common.interceptor;

import com.ssafy.faraway.domain.member.dto.res.MemberLoginResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        String requestMethod = request.getMethod();
        HttpSession session = request.getSession(false);

        // member 제외 모든 GET 요청 허용
        if (!requestURI.contains("member") && requestMethod.equals("GET")) {
            return true;
        }

        if (session == null || session.getAttribute("loginMember") == null) {
            if (isAjaxRequest(request)) {
                try {
                    response.sendError(400);
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
            return false;
        }
        return true;
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
