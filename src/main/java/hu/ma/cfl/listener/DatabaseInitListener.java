package hu.ma.cfl.listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;


public class DatabaseInitListener implements ServletContextListener {

	private static final Logger logger = Logger.getLogger(DatabaseInitListener.class.getName());

    private static final String CREATE_CUSTOMER_TABLE_SQL = """
            create table if not exists customer (
                id int primary key auto_increment,
                email varchar(255) not null unique,
                name varchar(255) not null,
                pw varchar(255) not null,
                salt char(24) not null
            );
            """;

    // Teszt felhasználó jelszava: Abcd1234
    private static final String INSERT_TEST_CUSTOMER_SQL = "insert into customer(email, name, pw, salt)" +
            " values('teszt@elek.hu', 'Teszt Elek', 'AusPGv5yMXJjsdECEspuXA==', 'NPLs7/cPOJHkRpa/9fYTUg==')";

    @Resource(name = "jdbc/mysql")
    private DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("Database init started");

        try (Connection connection = dataSource.getConnection()) {

            try (Statement statement = connection.createStatement()) {
                statement.execute("drop table if exists customer;");
                statement.executeUpdate(CREATE_CUSTOMER_TABLE_SQL);
                statement.executeUpdate(INSERT_TEST_CUSTOMER_SQL);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        logger.info("Database init finished");
    }


}
