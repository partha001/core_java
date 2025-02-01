package org.partha.p7Annotations.ex05;

import org.partha.p7Annotations.ex05.customAnnotations.Annotations;

import java.util.List;

public class SqlQueryBuilder {

    @Annotations.Input("ids")
    private List<String> ids;

    @Annotations.Input("limit")
    private Integer limit;

    @Annotations.Input("table")
    private String tableName;

    @Annotations.Input("columns")
    private List<String> columnNames;

    public SqlQueryBuilder(List<String> ids, Integer limit, String tableName, List<String> columnNames){
        this.ids = ids;
        this.limit = limit;
        this.tableName = tableName;
        this.columnNames = columnNames;
    }

    @Annotations.Operation("selectBuilder")
    public String selectStatementBuilder(@Annotations.Input("table") String tableName,@Annotations.Input("columns") List<String> columnNames){
        String columnsString = columnNames.isEmpty() ? "*" : String.join(",", columnNames);
        return String.format("select %s from %s", columnsString, tableName);
    }

    @Annotations.Operation("whereClauseBuilder")
    public String addWhereClause(@Annotations.DependsOn("selectBuilder") String query, @Annotations.Input("ids") List<String> ids){
        if(ids.isEmpty()){
            return query;
        }
        return String.format("%s where id in (%s)", query, String.join(",", ids));
    }

    @Annotations.FinalResult
    public String addLimit(@Annotations.DependsOn("whereClauseBuilder") String query,@Annotations.Input("limit") Integer limit){
        if (limit==null || limit==0){
            return query;
        }
        if(limit<0){
            throw new RuntimeException("limit cannot be negative");
        }
        return String.format("%s limit %d", query, limit.intValue());
    }

}
