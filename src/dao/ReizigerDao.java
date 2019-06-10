package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface ReizigerDao {
    public Reiziger findById(int id) throws SQLException, ParseException;
    public List<Reiziger> findByGBdatum(String GBdatum) throws SQLException;
    public Reiziger save(Reiziger reiziger) throws SQLException;
    public boolean update(Reiziger reiziger) throws SQLException;
    public boolean delete(Reiziger reiziger) throws SQLException;
}
