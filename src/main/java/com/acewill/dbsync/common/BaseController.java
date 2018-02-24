package com.acewill.dbsync.common;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class BaseController {
    
    private static final Log loger = LogFactory.getLog(BaseController.class);
    
    public void returnJSON(HttpServletResponse response, String msg){
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(msg);
            return;
        } catch (IOException e) {
            loger.error("returnJSON：返回异常" + e.toString());
            e.printStackTrace();
            return;
        }
    }
}
