/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.data;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author renea
 */
public class Conexion {
    private Connection conexion;
    private ResultSet rs;
    private PreparedStatement pst;
    private Statement st;
    private final String server;
    private final String database;

    public Connection getConexion() {
        return conexion;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public PreparedStatement getPst() {
        return pst;
    }

    public void setPst(String sql) {
        try {
            this.pst = conexion.prepareStatement(sql);
        } catch (SQLException ex) {
            
        }
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public Conexion() throws SQLException {
        conexion = null;
        server = "localhost";
        database = "Biblioteca";
        this.conectar();
    }

    public void conectar() throws SQLException {
        if (conexion.isClosed()) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("shadowman2");
            dataSource.setServerName(server);
            dataSource.setDatabaseName(database);
            conexion = dataSource.getConnection();
        } 
    }

    public void desconectar() throws SQLException {
        conexion.close();
    }
    
    public void cerrarRs() throws SQLException{
        rs.close();
    }
}
