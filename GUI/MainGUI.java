package GUI;

import db.db;
import java.awt.*;      
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import model.*;

public class MainGUI extends JFrame {

    // ==== FUNGSI KONEKSI DATABASE ====
    private Connection getConnection() {
        try {
            return db.getConnection();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Koneksi gagal: " + e.getMessage());
            return null;
        }
    }

    public MainGUI() {

        // === FRAME UTAMA ===
        JFrame kotak = new JFrame("Warnet Mas Neo");
        kotak.setSize(650, 780);
        kotak.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kotak.setLayout(new BorderLayout());
        kotak.setLocationRelativeTo(null);
        

        // Logo
        ImageIcon logo = new ImageIcon("logo isgath.png");
        kotak.setIconImage(logo.getImage());

        Font fontLabel = new Font("Arial", Font.BOLD, 16);
        Font fontInput = new Font("Arial", Font.PLAIN, 14);

        // === PANEL ATAS ===
        JPanel panelatas = new JPanel();
        panelatas.setBackground(new Color(0x3B0270));
        JLabel lbljudul = new JLabel("Warnet Mas Neo");
        lbljudul.setFont(new Font("Times New Roman", Font.BOLD, 26));
        lbljudul.setForeground(Color.WHITE);
        panelatas.add(lbljudul);
        kotak.add(panelatas, BorderLayout.NORTH);

        // === PANEL TENGAH ===
        JPanel paneltengah = new JPanel(new GridLayout(6, 2, 10, 20));
        paneltengah.setBorder(new EmptyBorder(20, 20, 20, 20));
        paneltengah.setBackground(new Color(0xE9E3DF));

        // Nama
        JLabel lblnama = new JLabel("Nama: ");
        lblnama.setFont(fontLabel);
        JTextField txtNama = new JTextField();
        txtNama.setFont(fontInput);
        paneltengah.add(lblnama);
        paneltengah.add(txtNama);

        // Username
        JLabel lblusrname = new JLabel("Username: ");
        lblusrname.setFont(fontLabel);
        JTextField txtusrname = new JTextField();
        txtusrname.setFont(fontInput);
        paneltengah.add(lblusrname);
        paneltengah.add(txtusrname);

        // Durasi
        JLabel lbldurasi = new JLabel("Durasi (jam): ");
        lbldurasi.setFont(fontLabel);
        Integer[] durasi = {1,2,3,4,5,6,7,8,9,10,11,12};
        JComboBox<Integer> combodurasi = new JComboBox<>(durasi);
        combodurasi.setFont(fontInput);
        paneltengah.add(lbldurasi);
        paneltengah.add(combodurasi);

        // Member
        JLabel lblmember = new JLabel("Member: ");
        lblmember.setFont(fontLabel);
        JRadioButton RBmemberY = new JRadioButton("Ya");
        JRadioButton RBmemberT = new JRadioButton("Tidak");
        RBmemberY.setFont(fontInput);
        RBmemberT.setFont(fontInput);

        ButtonGroup grupMember = new ButtonGroup();
        grupMember.add(RBmemberT);
        grupMember.add(RBmemberY);

        JPanel panelMember = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelMember.setBackground(new Color(0xF2F2F2));
        panelMember.add(RBmemberY);
        panelMember.add(RBmemberT);

        paneltengah.add(lblmember);
        paneltengah.add(panelMember);

        // Ruangan
        JLabel lblruang = new JLabel("Ruangan: ");
        lblruang.setFont(fontLabel);
        JRadioButton rbVIP = new JRadioButton("VIP");
        JRadioButton rbREG = new JRadioButton("Reguler");
        rbVIP.setFont(fontInput);
        rbREG.setFont(fontInput);

        ButtonGroup grupRuang = new ButtonGroup();
        grupRuang.add(rbVIP);
        grupRuang.add(rbREG);

        JPanel panelRuang = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelRuang.setBackground(new Color(0xF2F2F2));
        panelRuang.add(rbVIP);
        panelRuang.add(rbREG);

        paneltengah.add(lblruang);
        paneltengah.add(panelRuang);

        JLabel lbltambahan = new JLabel("Tambahan: ");
        lbltambahan.setFont(fontLabel);
        JCheckBox cekMkn = new JCheckBox("Wellcome Snack");
        JCheckBox cekMin = new JCheckBox("Wellcome Drink");
        cekMkn.setFont(fontInput);
        cekMin.setFont(fontInput);

        JPanel paneltambahan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        paneltambahan.add(cekMkn);
        paneltambahan.add(cekMin);

        paneltengah.add(lbltambahan);
        paneltengah.add(paneltambahan);


        // === PANEL BAWAH ===
        JPanel panelbawah = new JPanel(new BorderLayout(10, 10));
        panelbawah.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Tombol
        JPanel panelTombol = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnTambah = new JButton("Tambah");
        JButton btnEdit = new JButton("Edit");
        JButton btnReset = new JButton("Reset");
        JButton btnHapus = new JButton("Hapus");

        // Warna tombol
        btnTambah.setBackground(new Color(0x7A9E7E));
        btnTambah.setForeground(Color.WHITE);
        btnTambah.setOpaque(true);
        btnTambah.setBorderPainted(false);

        btnEdit.setBackground(new Color(0x6C8EBF));
        btnEdit.setForeground(Color.WHITE);
        btnEdit.setOpaque(true);
        btnEdit.setBorderPainted(false);

        btnReset.setBackground(new Color(0xC25B56));
        btnReset.setForeground(Color.WHITE);
        btnReset.setOpaque(true);
        btnReset.setBorderPainted(false);

        btnHapus.setBackground(new Color(0xD9534F));
        btnHapus.setForeground(Color.WHITE);
        btnHapus.setOpaque(true);
        btnHapus.setBorderPainted(false);

        btnTambah.setFont(fontInput);
        btnEdit.setFont(fontInput);
        btnReset.setFont(fontInput);
        btnHapus.setFont(fontInput);

        panelTombol.add(btnTambah);
        panelTombol.add(btnEdit);
        panelTombol.add(btnReset);
        panelTombol.add(btnHapus);

        // Tabel
        String[] kolom = {"ID", "Nama", "Username", "Durasi", "Member", "Ruangan","Harga", "Tambahan"};
        DefaultTableModel model = new DefaultTableModel(kolom, 0);
        JTable tabel = new JTable(model);
        tabel.setFont(fontInput); 
        tabel.setRowHeight(22);

        // Sembunyikan kolom ID
        tabel.getColumnModel().getColumn(0).setMinWidth(0);
        tabel.getColumnModel().getColumn(0).setMaxWidth(0);
        tabel.getColumnModel().getColumn(0).setWidth(0);

        tabel.getTableHeader().setFont(new Font("Arial", Font.BOLD, 14));
        tabel.getTableHeader().setBackground(new Color(0x8CCDEB));

        JScrollPane scroll = new JScrollPane(tabel);

        panelbawah.add(panelTombol, BorderLayout.NORTH);
        panelbawah.add(scroll, BorderLayout.CENTER);

        // === TOMBOL TAMBAH ===
        btnTambah.addActionListener(e -> {
        String nama = txtNama.getText().trim();
        String username = txtusrname.getText().trim();
        Integer durasiJam = (Integer) combodurasi.getSelectedItem();
        String member = RBmemberY.isSelected() ? "Ya" : "Tidak";
        String ruangan = rbVIP.isSelected() ? "VIP" : "Reguler";
        String tambahan = "";
        if (cekMkn.isSelected()) tambahan += "Snack ";
        if (cekMin.isSelected()) tambahan += "Drink ";
        if (tambahan.isEmpty()) tambahan = "-";

        boolean snack = cekMkn.isSelected();
        boolean drink = cekMin.isSelected();

        
        Pelanggan p;
        if (ruangan.equals("VIP")) {
            p = new PelangganVIP(nama, username, durasiJam, member, "VIP", snack, drink);
        } else {
            p = new Pelanggan(nama, username, durasiJam, member, ruangan, snack, drink);
        }

        int harga = p.hitungHarga();

        if (nama.isEmpty() || username.isEmpty()) {
            JOptionPane.showMessageDialog(kotak, "Nama dan Username tidak boleh kosong!");
            return;
        }

            try (Connection conn = getConnection()) {
                String sql = "INSERT INTO pelanggan (nama, username, durasi, member, ruangan, harga, tambahan) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, p.getNama());
                ps.setString(2, p.getUsername());
                ps.setInt(3, p.getDurasi());
                ps.setString(4, p.getMember());
                ps.setString(5, p.getRuangan());
                ps.setInt(6, harga);
                ps.setString(7, tambahan);

                ps.executeUpdate();


                ResultSet gen = ps.getGeneratedKeys();
                int idBaru = 0;
                if (gen.next()) idBaru = gen.getInt(1);

                model.addRow(new Object[]{idBaru, p.getNama(), p.getUsername(), p.getDurasi(),
                p.getMember(), p.getRuangan(), harga, tambahan});
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(kotak, "Gagal menyimpan ke database: " + ex.getMessage());
                return;
            }

            JOptionPane.showMessageDialog(kotak, "Data berhasil ditambahkan!");
        });

        // === TOMBOL EDIT ===
        btnEdit.addActionListener(e -> {
            int baris = tabel.getSelectedRow();
            if (baris == -1) {
                JOptionPane.showMessageDialog(kotak, "Pilih baris yang ingin diedit!");
                return;
            }

            String nama = txtNama.getText().trim();
            String username = txtusrname.getText().trim();
            Integer durasiJam = (Integer) combodurasi.getSelectedItem();
            String member = RBmemberY.isSelected() ? "Ya" : "Tidak";
            String ruangan = rbVIP.isSelected() ? "VIP" : "Reguler";
            String tambahan = "";
            if (cekMkn.isSelected()) tambahan += "Snack ";
            if (cekMin.isSelected()) tambahan += "Drink ";
            if (tambahan.isEmpty()) tambahan = "-";

            boolean snack = cekMkn.isSelected();
            boolean drink = cekMin.isSelected();

            // === Gunakan objek Pelanggan saat edit ===
            Pelanggan p;
            if (ruangan.equals("VIP")) {
                p = new PelangganVIP(nama, username, durasiJam, member, "VIP", snack, drink);
            } else {
                p = new Pelanggan(nama, username, durasiJam, member, ruangan, snack, drink);
            }

            int harga = p.hitungHarga();

            if (nama.isEmpty() || username.isEmpty()) {
                JOptionPane.showMessageDialog(kotak, "Nama dan Username tidak boleh kosong!");
                return;
            }

            int id = (int) model.getValueAt(baris, 0);

            // Update JTable
            model.setValueAt(p.getNama(), baris, 1);
            model.setValueAt(p.getUsername(), baris, 2);
            model.setValueAt(p.getDurasi(), baris, 3);
            model.setValueAt(p.getMember(), baris, 4);
            model.setValueAt(p.getRuangan(), baris, 5);
            model.setValueAt(harga, baris, 6);
            model.setValueAt(tambahan, baris, 7);



            // Update database
            try (Connection conn = getConnection()) {
                String sql = "UPDATE pelanggan SET nama=?, username=?, durasi=?, member=?, ruangan=?, harga=?, tambahan=? WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, p.getNama());
                ps.setString(2, p.getUsername());
                ps.setInt(3, p.getDurasi());
                ps.setString(4, p.getMember());
                ps.setString(5, p.getRuangan());
                ps.setInt(6, harga);
                ps.setString(7, tambahan);                
                ps.setInt(8, id);
                ps.executeUpdate();

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(kotak, "Gagal update database: " + ex.getMessage());
            }

            JOptionPane.showMessageDialog(kotak, "Data berhasil diedit!");
        });

        // === TOMBOL HAPUS ===
        btnHapus.addActionListener(e -> {
            int baris = tabel.getSelectedRow();
            if (baris == -1) {
                JOptionPane.showMessageDialog(kotak, "Pilih baris yang ingin dihapus!");
                return;
            }

            int konfirmasi = JOptionPane.showConfirmDialog(kotak,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);
            if (konfirmasi != JOptionPane.YES_OPTION) return;

            int id = (int) model.getValueAt(baris, 0);

            try (Connection conn = getConnection()) {
                String sql = "DELETE FROM pelanggan WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(kotak, "Gagal menghapus data: " + ex.getMessage());
                return;
            }

            model.removeRow(baris);
            JOptionPane.showMessageDialog(kotak, "Data berhasil dihapus!");
        });

        // === TOMBOL RESET ===
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtusrname.setText("");
            combodurasi.setSelectedIndex(0);
            grupRuang.clearSelection();
            grupMember.clearSelection();
            cekMkn.setSelected(false);
            cekMin.setSelected(false);
        });

        // === LOAD DATA SAAT PROGRAM DIBUKA ===
        try (Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pelanggan");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nama"),
                        rs.getString("username"),
                        rs.getInt("durasi"),
                        rs.getString("member"),
                        rs.getString("ruangan"),
                        rs.getInt("harga"),
                        rs.getString("Tambahan")
                });
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(kotak, "Gagal load data: " + ex.getMessage());
        }

        // === SPLIT PANEL ===
        JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, paneltengah, panelbawah);
        split.setDividerLocation(350);
        split.setResizeWeight(0.4);
        split.setDividerSize(8);

        kotak.add(split, BorderLayout.CENTER);
        kotak.setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
