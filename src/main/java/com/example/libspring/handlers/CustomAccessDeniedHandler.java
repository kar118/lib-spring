package com.example.libspring.handlers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
        try {
            httpServletResponse.getWriter().write(new JSONObject()
                    .put("HttpStatus", HttpStatus.FORBIDDEN.value())
                    .put("message", "You dont have a correct role.").toString());
        } catch (JSONException jsonException) {
            jsonException.printStackTrace();
        }
    }
}
