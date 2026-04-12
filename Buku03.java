public class Buku03 {

    String kodeBuku;
    String judul;
    int tahunTerbit;

    // Constructor dengan parameter
    Buku03(String kode, String judul, int tahun){
        kodeBuku = kode;
        this.judul = judul;
        tahunTerbit = tahun;
    }

    // Method untuk menampilkan data buku
    void tampilBuku(){
        System.out.println( "Kode: " + kodeBuku +  " | Judul: " + judul + " | Tahun: " + tahunTerbit );
    }
}