package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends ModeloBase{
    private int iduser;
    private String username;
    private String password;
    private Rol rol;

    public User() {
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIduser() {
        return iduser;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    protected String getNombreTabla() {
        return "user";
    }


    @Override
    public String toString() {
        return "User{" +
                "iduser=" + iduser +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rol=" + rol +
                '}';
    }

    public User login(String username, String password) {
        User user=new User();
        Connection conn=user.getConnection();
        String sql="select iduser,username,rol.idrol,description from " +
                "user left join rol on user.idrol=rol.idrol " +
                "where username=? and password=?";
        try {
            PreparedStatement pst=conn.prepareStatement(sql);
            pst.setString(1,username);
            pst.setString(2,password);
            ResultSet resultSet=pst.executeQuery();
            if(resultSet.next()){
                user.iduser=resultSet.getInt("iduser");
                user.username=resultSet.getString("username");
                Rol rol=new Rol();
                rol.setIdrol(resultSet.getInt("idrol"));
                rol.setDescription(resultSet.getString("description"));
                user.rol=rol;
                return user;
            }else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
