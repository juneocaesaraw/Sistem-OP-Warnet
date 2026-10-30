package model;

    public class Pelanggan {
    private int id;
    private String nama;
    private String username;
    private int durasi;
    private String member;
    private String ruangan;
    private boolean snack ;
    private boolean drink;

    public Pelanggan() {}

    public Pelanggan(String nama, String username, int durasi, String member, String ruangan, boolean snack, boolean drink) {
        this.nama = nama;
        this.username = username;
        this.durasi = durasi;
        this.member = member;
        this.ruangan = ruangan;
        this.snack = snack;
        this.drink = drink;
    }

    // Getter-setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public int getDurasi() { return durasi; }
    public void setDurasi(int durasi) { this.durasi = durasi; }

    public String getMember() { return member; }
    public void setMember(String member) { this.member = member; }

    public String getRuangan() { return ruangan; }
    public void setRuangan(String ruangan) { this.ruangan = ruangan; }

    public boolean getSnack(){return snack;}
    public void setSnack(boolean snack){this.snack = snack;}

    public boolean getDrink(){return drink;}
    public void setDrink(boolean drink){this.drink = drink;}

    public int hitungHarga() {
    int hargaPerJam = 5000;
    int total = durasi * hargaPerJam;

    if (member.equalsIgnoreCase("Ya")) {
        total *= 0.8;  
    }
    if (snack) total +=500;
    if (drink) total +=500;

    return total;
}
}
