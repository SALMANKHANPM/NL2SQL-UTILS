package org.dialectConvertor;

import org.jooq.Parser;
import org.jooq.Query;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        String postgresSQL = "SELECT * FROM users WHERE name ILIKE 'john%'";

        // Parse PostgreSQL SQL
        Parser parser = DSL.using(SQLDialect.POSTGRES).parser();
        Query query = parser.parseQuery(postgresSQL);

        // Render it as MariaDB SQL
        String mariadbSQL = DSL.using(SQLDialect.MARIADB)
                .render(query);
        String mySQL = DSL.using(SQLDialect.MYSQL).render(query);

        System.out.println("PostgresSQL: " + query);
        System.out.println("MariaDB SQL: " + mariadbSQL);
        System.out.println("MySQL:       " + mySQL);

    }
}