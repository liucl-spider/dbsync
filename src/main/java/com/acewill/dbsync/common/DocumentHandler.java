package com.acewill.dbsync.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import javax.servlet.ServletContext;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * http request生成 word文档输出流
 * @author Liucl
 * @datetime 2016年7月28日 上午10:56:22
 */
public class DocumentHandler {
    
    private Configuration configuration = null;
    
    private ServletContext context;
    
    public DocumentHandler() {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
    }
    
    public DocumentHandler(ServletContext context) {
        configuration = new Configuration();
        configuration.setDefaultEncoding("utf-8");
        this.context = context;
    }
    
    // http://192.168.1.40:8080/acewill/pcrecruit/exportRecurit.htm?id=40
    public void createDoc(Map<String, Object> dataMap, PrintWriter out, String tempFilePath)
        throws UnsupportedEncodingException {
        // dataMap 要填入模本的数据文件
        // 设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库装载，
        // 指定模板文件夹
        configuration.setServletContextForTemplateLoading(context, "/template");// setClassForTemplateLoading(this.getClass(),
                                                                                // "/template");
        Template t = null;
        try {
            // 设置要装载的模板
            t = configuration.getTemplate(tempFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            t.process(dataMap, out);
            out.close();
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}