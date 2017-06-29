package com.j2ee.demo.webapi.common;

/**
 * Created by rihaizhang on 2017/6/6.
 */

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {


    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }


    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        // TODO Auto-generated method stub
        String str = arg0.getCharacterEncoding();
        String aString = str;

        arg0.setCharacterEncoding("UTF-8");
        arg2.doFilter(arg0, arg1);
    }


    public void destroy() {
        // TODO Auto-generated method stub

    }

}