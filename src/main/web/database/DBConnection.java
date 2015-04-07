package database;

import constants.Constants;
import entity.Discipline;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public class DBConnection implements Constants {
    private Connection conn = null;
    private ResultSet rs = null;
    private static PreparedStatement getDisciplinesList;
    private static PreparedStatement setDiscipline;
    private static PreparedStatement setDisciplinesByIdDelete;
    private static PreparedStatement getDisciplineById;
    private static PreparedStatement setDisciplineByIdUpdate;


    public DBConnection() {
        /** Загрузка Драйвера JDBC */
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (Exception e) {
            System.out.println("SQLException -> DBConnection() " + e);
        }
    }

    public void loadPreparedStatements() {
        try {
            getDisciplinesList = conn.prepareStatement("SELECT * FROM disciplines ORDER BY id");
            getDisciplineById = conn.prepareStatement("SELECT * FROM disciplines WHERE id =?");
            setDiscipline = conn.prepareStatement("INSERT INTO disciplines (name) VALUES (?)");
            setDisciplinesByIdDelete = conn.prepareStatement("DELETE FROM disciplines WHERE id =?");
            setDisciplineByIdUpdate = conn.prepareStatement("UPDATE disciplines SET name=? WHERE id=?");
        } catch (SQLException e) {
            System.out.println("SQLException -> loadPreparedStatements()" + e);
        }
    }

    public void closePreparedStatements() {
        try {
            getDisciplinesList.close();
            setDiscipline.close();
            setDisciplinesByIdDelete.close();
            getDisciplineById.close();
            setDisciplineByIdUpdate.close();
        } catch (SQLException e) {
            System.out.println("SQLException -> closePreparedStatements()" + e);
        }
    }


    //***************** Discipline *************************************
    public List<Discipline> getDisciplinesList() {
        rs = null;
        List<Discipline> disciplinesList = new LinkedList<Discipline>();
        try {
            //SELECT * FROM disciplines
            rs = getDisciplinesList.executeQuery();
            while (rs.next()) {
                Discipline discipline = new Discipline();
                discipline.setId(rs.getInt("id"));
                discipline.setName(rs.getString("name"));
                disciplinesList.add(discipline);
            }
        } catch (SQLException e) {
            System.out.println("SQLException -> getDisciplinesList()" + e);
        }
        return disciplinesList;
    }

    public void setDisciplineAdd(Discipline discipline) {
        //"INSERT INTO disciplines (name) VALUES (?)";
        try {
            setDiscipline.setString(1, discipline.getName());
            setDiscipline.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException -> setDisciplineAdd()" + e);
        }
    }

    public void setDisciplineByIdDelete(int id) {
        //DELETE FROM disciplines WHERE id =?
        try {
            setDisciplinesByIdDelete.setInt(1, id);
            setDisciplinesByIdDelete.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException -> setDisciplineByIdDelete()" + e);
        }
    }

    public Discipline getDisciplineById(int id) {
        rs = null;
        Discipline discipline = new Discipline();
        try {
            //SELECT * FROM disciplines WHERE id =?"
            getDisciplineById.setInt(1, id);
            rs = getDisciplineById.executeQuery();
            while (rs.next()) {
                discipline.setId(rs.getInt("id"));
                discipline.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException -> getDisciplineById()" + e);
        }
        return discipline;
    }

    public void setDisciplineById(Discipline discipline) {
        //UPDATE disciplines SET name=? WHERE id=?
        try {
            setDisciplineByIdUpdate.setString(1, discipline.getName());
            setDisciplineByIdUpdate.setInt(2, discipline.getId());
            setDisciplineByIdUpdate.executeUpdate();
        } catch (SQLException e) {
            System.out.println("SQLException -> setDisciplineById()" + e);
        }
    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
