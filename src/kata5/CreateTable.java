package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
    
    public void createNewTable(){
        String url = "jdbc:sqlite:mail.db";
        String sql = "CREATE TABLE IF NOT EXISTS direcc_email(\n"
                     + " id integer PRIMARY KEY AUTOINCREMENT,\n"
                     + " direccion text NOT NULL);";
        try(Connection conn = DriverManager.getConnection(url)){
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            System.out.println("Tabla creada.");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
