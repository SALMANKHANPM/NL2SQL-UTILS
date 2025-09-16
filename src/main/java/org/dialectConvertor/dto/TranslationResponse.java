package org.dialectConvertor.dto;

public class TranslationResponse {
    private String translatedSql;

    public TranslationResponse(String translatedSql) {
        this.translatedSql = translatedSql;
    }

    public String getTranslatedSql() { return translatedSql; }
}