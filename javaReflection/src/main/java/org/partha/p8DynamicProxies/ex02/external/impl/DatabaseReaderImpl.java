package org.partha.p8DynamicProxies.ex02.external.impl;

import org.partha.p8DynamicProxies.ex02.external.DatabaseReader;

import java.io.IOException;

public class DatabaseReaderImpl implements DatabaseReader {
    @Override
    public int countRowsInTable(String tableName) throws InterruptedException,IOException {
        System.out.println(String.format("DatabaseReaderImpl - counting rows in table %s", tableName));
//        Thread.sleep(1000);
//        return 50;
        throw new IOException("error counting rows in the table "+tableName);
    }

    @Override
    public String[] readRow(String sqlQuery) throws InterruptedException {
        System.out.println(String.format("DatabaseReaderImpl - Executing Sql query : %s",sqlQuery));
        Thread.sleep(1500);
        return new String[]{"column1","column2","column3"};
    }
}
