package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectApp {
    
    public void selectAll(){
        String sql="SELECT * FROM PEOPLE";
        try {
            Connection con = this.connect();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                System.out.println(rs.getInt("ID") + "\t" + 
                                   rs.getString("Name") + "\t" +
                                   rs.getString("Apellidos") + "\t" +
                                   rs.getString("Departamento") + "\t" );
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private Connection connect() {
        Connection con = null;
        try {
            String url = "jdbc:sqlite:C:\\Users\\sumit\\OneDrive\\Escritorio\\SQLiteDatabaseBrowserPortable\\Data\\Prueba.db";
            con = DriverManager.getConnection(url);
            System.out.println("Conexión a SQLite establecida");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}
