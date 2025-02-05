package org.partha.p8DynamicProxies.ex01.external;

public interface DatabaseReader {

    int countRowsInTable(String tableName) throws InterruptedException;

    String[] readRow(String sqlQuery) throws InterruptedException;
}
