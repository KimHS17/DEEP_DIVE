package com.delivery.api.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

@Slf4j
@Component
public class LoggerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        var req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        filterChain.doFilter(req, res);

        // request 정보
        var headerNames = req.getHeaderNames();
        var headerValues = new StringBuilder();

        headerNames.asIterator().forEachRemaining(headerkey -> {
            var headerValue = req.getHeader(headerkey);

            headerValues.append(headerkey).append(" : ").append(headerValue).append(", ");
        });

        var requestBody = new String(req.getContentAsByteArray());

        log.info(">>>> header : {}, body : {}", headerValues, requestBody);

        // response 정보
        var responseHeaderValues = new StringBuilder();

        res.getHeaderNames().forEach(headerkey -> {
            var headerValue = res.getHeader(headerkey);

            responseHeaderValues.append(headerkey).append(" : ").append(headerValue).append(", ");
        });

        var responseBody = new String(res.getContentAsByteArray());

        log.info("<<<< header : {}, body : {}", responseHeaderValues, responseBody);

        res.copyBodyToResponse(); // responseBody 내용을 앞에서 모두 읽어버려서 초기화 해주지 않으면 반 responseBody
    }
}
