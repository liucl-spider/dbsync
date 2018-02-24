package com.acewill.dbsync.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomBooleanEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.acewill.dbsync.common.BaseController;
import com.acewill.dbsync.service.SyncService;


@Controller
@RequestMapping(value = "sync")
public class SyncController extends BaseController{
    
    @Autowired
    private SyncService syncService;
    
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.registerCustomEditor(Boolean.class, new CustomBooleanEditor(true));
    }
    
    @RequestMapping(value = "/init.htm")
    public void init(HttpServletRequest request, HttpServletResponse response, String master, String slaver) {
        String result = syncService.generateSql(master, slaver);
        returnJSON(response, result);
    }
}