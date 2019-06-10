package dao;

import java.util.Date;

public class Reiziger {

    private int id;
    private String naam;
    private Date gbdatum;
    private String voorletters;


    public Reiziger(int id, String naam, String voorletters, Date gbdatum) {
        this.id = id;
        this.naam = naam;
        this.voorletters = voorletters;
        this.gbdatum = gbdatum;
    }

    public int getId(){

        return id;
    }

    public void setId(int idd){
        this.id = idd;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String nm) {
        naam = nm;
    }

    public void setVoorletters(String vrl){
        this.voorletters = vrl;
    }

    public String getVoorletters(){
        return voorletters;
    }


    public Date getGbdatum() {
        return gbdatum;
    }

    public void setGbdatum(Date datum){
        gbdatum = datum;
    }

    @Override
    public String toString() {
        return "Reizigerid = "+ id +
                ", voorletter= "+voorletters+
                ", naam='" + naam + '\'' +
                ", geboortedatum=" + gbdatum;
    }
}
