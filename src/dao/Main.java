package dao;

import jdk.jfr.StackTrace;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException, ParseException {
        ReizigerOracleDaoImpl ding = new ReizigerOracleDaoImpl();
        OVChipkaartOracleDaoImpl ov = new OVChipkaartOracleDaoImpl();


        // Twee reizigers worden hier aangemaakt
        String datum = "05-01-2009";
        Date datum_1 = new SimpleDateFormat("dd-MM-yyyy").parse(datum);
        Reiziger eerstereiziger = new Reiziger(224,"HUYS","KM", datum_1);
        String datum2 = "05-01-2003";
        Date datum_3 = new SimpleDateFormat("dd-MM-yyyy").parse(datum2);
        Reiziger tweedereiziger = new Reiziger(223,"Luuk","JD", datum_3);

        String datum4 = "06-02-2002";
        Date datum_4 = new SimpleDateFormat("dd-MM-yyyy").parse(datum4);
        Reiziger derdereiziger = new Reiziger(885,"Koeman", "KL", datum_4);


        String ovdatum1 = "06-03-2022";
        String ovdatum3 = "07-04-2019";
        Date datumgeldig1 = new SimpleDateFormat("dd-MM-yyyy").parse(ovdatum1);
        Date datumgeldig2 = new SimpleDateFormat("dd-MM-yyyy").parse(ovdatum3);
        //Twee ov chipkaarten worden hier aangemaakt
        OVChipkaart ov1 = new OVChipkaart(4040,datumgeldig1,2,30,eerstereiziger);
        OVChipkaart ov2 = new OVChipkaart(4080,datumgeldig2, 2,40,derdereiziger);




//        System.out.println(ding.findById(4));
//        System.out.println(ding.findByGBdatum("11-08-98"));

        // twee reizigers worden hier opgeslagen in de database
//        ding.save(eerstereiziger);
//        ding.save(tweedereiziger);
//


//        ding.findByGBdatum("06/01/2003");
//        ding.delete(tweedereiziger);
//        ding.update(eerstereiziger);
//        ding.save(derdereiziger);
//        ov.save(ov1);
//        ov.save(ov2);
//        System.out.println(ov.findAll());
//        System.out.println(ov.findByReiziger(eerstereiziger));
//        ov.delete(ov1);
//        ov.update(ov2);
//        System.out.println(ding.findById(224));
//        System.out.println(ov.findAll());




    }


}
