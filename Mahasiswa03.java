public class Mahasiswa03 { 
    String nim;
    String nama;
    String prodi;

    // Constructor default (tanpa parameter)
    Mahasiswa03(){
    }

    // Constructor dengan parameter
    Mahasiswa03(String nim, String nama, String prodi){
        this.nim = nim;
        this.nama = nama;
        this.prodi = prodi;
    }

    // Method untuk menampilkan data mahasiswa
    void tampilMahasiswa(){
        System.out.println( "NIM: " + nim + " | Nama: " + nama + " | Prodi: " + prodi);
    }
}