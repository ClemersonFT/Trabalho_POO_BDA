package imobiliaria.dao;
import java.sql.Connection;
import java.sql.SQLException;

public class BaseDAO {
    protected Connection c() throws SQLException {
        return ConnectionFactory.getInstance().get();
    }
}