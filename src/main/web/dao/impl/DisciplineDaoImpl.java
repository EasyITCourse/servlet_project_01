package dao.impl;

import dao.DisciplineDao;
import database.DBConnection;
import entity.Discipline;

import java.util.List;

public class DisciplineDaoImpl implements DisciplineDao{
    @Override
    public List<Discipline> getDisciplines() {
        DBConnection dbConnection = new DBConnection();
        dbConnection.loadPreparedStatements();
        return dbConnection.getDisciplinesList();
    }

    @Override
    public Discipline getDisciplineById(int id) {
        return null;
    }

    @Override
    public boolean updateDiscipline(Discipline discipline) {
        return false;
    }

    @Override
    public boolean addDiscipline(Discipline discipline) {
        return false;
    }

    @Override
    public boolean deleteeDiscipline(int id) {
        return false;
    }
}
