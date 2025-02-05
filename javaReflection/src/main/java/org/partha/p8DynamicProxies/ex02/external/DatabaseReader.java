package org.partha.p8DynamicProxies.ex02.external;

import java.io.IOException;

public interface DatabaseReader {

    int countRowsInTable(String tableName) throws InterruptedException, IOException;

    String[] readRow(String sqlQuery) throws InterruptedException;
}
