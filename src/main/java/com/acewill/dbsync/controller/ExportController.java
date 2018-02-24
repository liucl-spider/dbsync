package com.acewill.dbsync.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acewill.dbsync.common.DocumentHandler;
import com.acewill.dbsync.entity.Table;
import com.acewill.dbsync.service.SyncService;

@Controller
@RequestMapping(value = "export")
public class ExportController {
    
    @Autowired
    private SyncService syncService;
    
    @RequestMapping(value = "/tableWord.htm")
    public void init(HttpServletRequest request, HttpServletResponse response, String master, String slaver) throws UnsupportedEncodingException, IOException {
        response.setContentType("application/x-msdownload;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + new String("数据库结构.doc".getBytes("utf-8"), "iso-8859-1"));
        List<Table> tableList = syncService.getAllTables();
        DocumentHandler doc = new DocumentHandler(request.getSession().getServletContext());
        Map<String,Object> dataMap = new HashMap<String,Object>();
        dataMap.put("tableList", tableList);
        doc.createDoc(dataMap, response.getWriter(), "template.ftl");
    }
    
}
