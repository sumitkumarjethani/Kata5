package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTableData {
    
    public void insert(String email){
        try {
            Connection conn = this.connect();
            String sql = "INSERT INTO direcc_email(direccion) VALUES(?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private Connection connect() {
        Connection con = null;
        try {
            String url = "jdbc:sqlite:mail.db";
            con = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
