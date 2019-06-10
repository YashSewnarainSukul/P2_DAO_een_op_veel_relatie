package dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.text.DateFormat;

public class ReizigerOracleDaoImpl extends OracleBaseDao implements ReizigerDao {

    public ReizigerOracleDaoImpl() throws SQLException {
        System.out.println("Reiziger DAO is accessed ");
    }

    public Reiziger findById(int id) throws SQLException, ParseException {
        Connection myConn = super.getConnection();
        int reizgerID = id;
        Reiziger r = new Reiziger(0, "leeg", "y.s", null);
        try {
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select REIZIGERID, VOORLETTERS, ACHTERNAAM, GEBORTEDATUM from REIZIGER where REIZIGERID = " + id+"");
            while (myRs.next()) {
                r.setNaam(myRs.getString("ACHTERNAAM"));
                r.setGbdatum(myRs.getDate("GEBORTEDATUM"));
                r.setId(myRs.getInt("REIZIGERID"));
                r.setVoorletters(myRs.getString("VOORLETTERS"));
            }
        } catch (SQLException s) {
            s.printStackTrace();
        }

        return r;
    }

    public List<Reiziger> findByGBdatum(String gbdatum) throws SQLException {
        Connection myConn = super.getConnection();
        String goededatum = gbdatum;
        List<Reiziger> reizigers = new ArrayList<Reiziger>();
        try {
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select VOORLETTERS, ACHTERNAAM, GEBORTEDATUM,REIZIGERID from REIZIGER where GEBORTEDATUM = '" + goededatum + "'");
            while (myRs.next()) {
                Reiziger r = new Reiziger(0,null,null,null);
                r.setNaam(myRs.getString("ACHTERNAAM"));
                r.setId(myRs.getInt("REIZIGERID"));
                r.setVoorletters(myRs.getString("VOORLETTERS"));
                r.setGbdatum(myRs.getDate("GEBORTEDATUM"));
                reizigers.add(r);
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
        return reizigers;
    }


    public Reiziger save(Reiziger reiziger) throws SQLException {
        Connection myConn = super.getConnection();
        String voorletter = reiziger.getVoorletters();
        int id = reiziger.getId();
        String naam = reiziger.getNaam();
        Date datum = reiziger.getGbdatum();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String x = dateFormat.format(datum);

        try  {
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("INSERT INTO REIZIGER (REIZIGERID, VOORLETTERS,ACHTERNAAM,GEBORTEDATUM) VALUES (" + id + ",'" + voorletter + "','" + naam + "','"+x+"')");
            System.out.println(reiziger.toString()+ " is opgeslagen!");
        } catch (SQLException s) {
            s.printStackTrace();
        }
        return reiziger;
    }


    public boolean update(Reiziger reiziger) throws SQLException {
        Connection myConn = super.getConnection();
        String voorletter = reiziger.getVoorletters();
        int id = reiziger.getId();
        String naam = reiziger.getNaam();
        Date datas = reiziger.getGbdatum();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String s = dateFormat.format(datas);
        boolean x = false;
        try  {
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("UPDATE REIZIGER SET  GEBORTEDATUM = '"+ s +"',VOORLETTERS = '" + voorletter + "', ACHTERNAAM = '" + naam + "' WHERE REIZIGERID =" + id +"");
            System.out.println(reiziger.toString() + "is bijgewerkt");
            x = true;
        } catch (SQLException i) {
            i.printStackTrace();
        }
        return x;
    }


    public boolean delete(Reiziger reiziger) throws SQLException {
        Connection myConn = super.getConnection();
        boolean gedelete = false;
        int id = reiziger.getId();
        try  {
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("DELETE FROM REIZIGER WHERE REIZIGERID = " + id + "");
            gedelete = true;
            System.out.println(reiziger.toString() + "is verwijderd");
        } catch (SQLException s){
            s.printStackTrace();
        }
        return gedelete;
    }

}



