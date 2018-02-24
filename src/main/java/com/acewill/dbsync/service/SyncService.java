package com.acewill.dbsync.service;

import java.io.IOException;
import java.util.List;

import com.acewill.dbsync.entity.Table;

public interface SyncService {
    
    public String generateSql();
    
    
    public String generateSql(String master, String slaver);


    public List<Table> getAllTables() throws IOException;
}
