package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public interface OVChipkaartDao {
    public OVChipkaart save(OVChipkaart Reiziger) throws SQLException;
    public List<OVChipkaart> findAll() throws  SQLException, ParseException;
    public List<OVChipkaart> findByReiziger(Reiziger r)  throws SQLException, ParseException;
    public OVChipkaart update(OVChipkaart ov) throws SQLException;
    public boolean delete (OVChipkaart ov)throws SQLException ;

}
