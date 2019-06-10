package dao;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.*;

import java.sql.ResultSet;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao{
    public OVChipkaartOracleDaoImpl() throws SQLException {
        System.out.println("OV Dao is accessed ");
    }

    // Save ov chipcard in database
    public OVChipkaart save(OVChipkaart ov) throws SQLException{
        Connection myConn = super.getConnection();
        int kaartNummer = ov.getKaartNummer();
        int klass = ov.getKlasse();
        float saldo = ov.getSaldo();
        Reiziger eigeinaar = ov.getEigenaar();
        int id = eigeinaar.getId();

        Date geldigheid = ov.getGeldigTot();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String s = dateFormat.format(geldigheid);
        try  {
            Statement myStmt = myConn.createStatement();
            ResultSet myrs = myStmt.executeQuery("INSERT INTO OV_CHIPKAART (KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID) VALUES(" + kaartNummer + ",'" + s + "'," + klass + "," + saldo + "," + id + ")");
            System.out.println(ov.toString() + " IS OPGESLAGEN");
            return ov;

        } catch (SQLException r) {
            r.printStackTrace();
        }
        return null;
    }

    //   Get all cards from the database
    public List<OVChipkaart> findAll() throws ParseException, SQLException {
        Connection myConn = super.getConnection();
        List<OVChipkaart> reizigerkaart = new ArrayList<OVChipkaart>();
        try {
            Statement mystmt = myConn.createStatement();
            ResultSet rs = mystmt.executeQuery("SELECT * FROM OV_CHIPKAART");
            while (rs.next()) {
                ReizigerOracleDaoImpl raw = new ReizigerOracleDaoImpl();
                OVChipkaart ov = new OVChipkaart(0, null, 1, 0, null);
                ov.setSaldo(rs.getFloat("SALDO"));
                ov.setKlasse(rs.getInt("KLASSE"));
                ov.setGeldigTot(rs.getDate("GELDIGTOT"));
                ov.setEigenaar(raw.findById(rs.getInt("REIZIGERID")));
                reizigerkaart.add(ov);

            }
            return reizigerkaart;

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return null;
    }

    //  Search ov chipcards in database by traveler.
    public List<OVChipkaart> findByReiziger(Reiziger r) throws ParseException, SQLException{
        Connection myconn = super.getConnection();
        int id = r.getId();
        List<OVChipkaart> reizigerkaart = new ArrayList<OVChipkaart>();
        try {
            Statement stmt = myconn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OV_CHIPKAART WHERE REIZIGERID =" + id + "");
            while (rs.next()) {
                ReizigerOracleDaoImpl raw = new ReizigerOracleDaoImpl();
                OVChipkaart ov = new OVChipkaart(0, null, 1, 0, null);
                ov.setKaartNummer(rs.getInt("KAARTNUMMER"));
                ov.setEigenaar(raw.findById(rs.getInt("REIZIGERID")));
                ov.setGeldigTot(rs.getDate("GELDIGTOT"));
                ov.setKlasse(rs.getInt("KLASSE"));
                ov.setSaldo(rs.getFloat("SALDO"));
                reizigerkaart.add(ov);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return reizigerkaart;
    }

    //    Update  OV Chipkaart data. Card number and travelers ID cannot be changed
    public OVChipkaart update(OVChipkaart ov) throws SQLException {
        Connection myconn = super.getConnection();
        int kaartNummer = ov.getKaartNummer();
        int klass = ov.getKlasse();
        float saldo = ov.getSaldo();
        Reiziger eigeinaar = ov.getEigenaar();
        int id = eigeinaar.getId();
        try  {
            Statement mySmt = myconn.createStatement();
            ResultSet myrs = mySmt.executeQuery("UPDATE OV_CHIPKAART SET  KLASSE =" + klass + ",SALDO = " + saldo + " WHERE KAARTNUMMER =" + kaartNummer + "");
            System.out.println(ov.toString() + " is bijgewerkt");

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return ov;
    }


    //    Delete OV chipcard from database
    public boolean delete(OVChipkaart ov) throws SQLException {
        Connection myconn = super.getConnection();
        boolean gedelete = false;
        int id = ov.getKaartNummer();
        try  {
            Statement mystmt = myconn.createStatement();
            ResultSet myrs = mystmt.executeQuery("DELETE FROM OV_CHIPKAART WHERE KAARTNUMMER = " + id + "");
            gedelete = true;
            System.out.println(ov.toString() + "is verwijderd");

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return gedelete;
    }

}
