package cn.zx.Filter;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ssm
 * @description:
 * @author: zx
 * @create: 2018-12-13 17:08
 **/
public class reFilter extends OncePerRequestFilter {


    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String ip=httpServletRequest.getRemoteAddr();
        String url=httpServletRequest.getRequestURL().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        String date = sdf.format(d);
        System.out.printf("%s %s 访问了 %s%n", date, ip, url);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

}
