public class ListMahasiswa03 {
    // Array untuk menyimpan beberapa object Mahasiswa03 (Maks 3 data)
    Mahasiswa03 [] listMhs = new Mahasiswa03[3]; 
    int idx; // Penanda jumlah data yang tersimpan

    // Method untuk menambah data mahasiswa ke dalam array
    void tambah(Mahasiswa03 m) {
        if (idx<listMhs.length) { // Cek apakah array masih tersedia
            listMhs[idx] = m;     // Simpan data mahasiswa ke posisi index saat ini
            idx++;                // Increment index untuk data berikutnya
        }else {
            System.out.println("Data sudah penuh"); // jika array penuh
        }
    }

    // Method untuk menampilkan seluruh data mahasiswa yang tersimpan dalam array
    void tampil() {
        for (int i = 0; i < idx; i++) {   // Looping hanya sampai jumlah data yang terisi
            listMhs[i].tampilMahasiswa(); // Memanggil method tampil dari setiap objek mahasiswa
        }
    } 
}