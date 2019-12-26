package kata5;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateBD {
    public void createNewDatabase(String filename){
        String url = "jdbc:sqlite:" + filename;
        try(Connection con = DriverManager.getConnection(url)){
            if(con != null){
                DatabaseMetaData meta = con.getMetaData();
                System.out.println("El driver es: " + meta.getDriverName());
                System.out.println("Se ha creado la nueva Base de Datos");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
