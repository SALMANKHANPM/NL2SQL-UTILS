package org.dialectConvertor.dto;

public class TranslationRequest {
    private String sql;
    private String sourceDialect;
    private String targetDialect;

    // Getters and Setters
    public String getSql() { return sql; }
    public void setSql(String sql) { this.sql = sql; }

    public String getSourceDialect() { return sourceDialect; }
    public void setSourceDialect(String sourceDialect) { this.sourceDialect = sourceDialect; }

    public String getTargetDialect() { return targetDialect; }
    public void setTargetDialect(String targetDialect) { this.targetDialect = targetDialect; }
}