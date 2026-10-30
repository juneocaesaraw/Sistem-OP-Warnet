package model;

public class PelangganVIP extends Pelanggan {

    public PelangganVIP(String nama, String username, int durasi, String member, String ruangan, boolean
     snack, boolean drink) {
        super(nama, username, durasi, member, ruangan, snack, drink);
    }

    @Override
    public int hitungHarga() {
        int hargaPerJam = 10000;
        int total = getDurasi() * hargaPerJam;

        if (getMember() != null && getMember().equalsIgnoreCase("Ya")) {
            total*= 0.8; 
        }

        if (getSnack()) total +=500;
        if (getDrink()) total +=500;
        return total;
    }

}
