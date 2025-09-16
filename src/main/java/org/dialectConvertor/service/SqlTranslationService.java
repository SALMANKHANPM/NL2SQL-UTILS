package org.dialectConvertor.service;

import org.jooq.Parser;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.springframework.stereotype.Service;

@Service
public class SqlTranslationService {

    public String translate(String sql, SQLDialect sourceDialect, SQLDialect targetDialect) {
        try {
            System.out.println("=== REQUEST ====");
            System.out.println("Req Query : " + sql);
            System.out.println("Source Dialect : " + sourceDialect);
            System.out.println("Target Dialect : " + targetDialect);
            Parser parser = DSL.using(sourceDialect).parser();
            Query query = parser.parseQuery(sql);
            return DSL.using(targetDialect).render(query);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse or translate SQL: " + e.getMessage(), e);
        }
    }
}