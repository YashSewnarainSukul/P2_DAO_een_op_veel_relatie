package dao;
import java.util.Date;
public class OVChipkaart {
    private int kaartNummer;
    private Date geldigTot;
    private int klasse;
    private float saldo;
    private Reiziger eigenaar;

   public OVChipkaart(int kt, Date geldig, int klas, float sald, Reiziger e) {
        kaartNummer = kt;
        geldigTot = geldig;
        klasse = klas;
        saldo = sald;
        eigenaar = e;

    }

    public int getKaartNummer() {
        return kaartNummer;
    }

    public void setKaartNummer(int kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;

    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Reiziger getEigenaar() {
        return eigenaar;
    }

    public void setEigenaar(Reiziger eigenaar) {
        this.eigenaar = eigenaar;
    }


    public String toString() {
        return "OVChipkaart " + "kaartNummer=" + kaartNummer + ", geldigTot=" + geldigTot +
                ", klase=" + klasse + ", saldo=" + saldo + ", eigenaar=" + eigenaar;
    }
}
