public class Peminjaman03 {
    
    Mahasiswa03 mhs;
    Buku03 buku;
    int lamaPinjam;
    int terlambat = 0;
    int denda;

    // Constructor dengan parameter
    Peminjaman03(Mahasiswa03 mhs, Buku03 buku, int lamaPinjam){
        this.mhs = mhs;
        this.buku = buku;
        this.lamaPinjam = lamaPinjam;
    }

    // Method untuk menghitung denda
    void hitungDenda(){
        int batasPinjam = 5;
        if (lamaPinjam > batasPinjam) {
            terlambat = lamaPinjam - batasPinjam;
            denda = terlambat * 2000;
        } else {
            terlambat = 0;
            denda = 0;
        }
    }

    // Method untuk menampilkan data peminjaman
    void tampilPeminjaman(){
        System.out.println( mhs.nama + " | " + buku.judul + " | Lama: " + lamaPinjam + 
        " | Terlambat: " + terlambat + " | Denda: " + denda);
    }
}