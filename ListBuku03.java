public class ListBuku03 {
    // Array untuk menyimpan beberapa object Buku03 (Maks 4 data)
    Buku03 [] listBuku = new Buku03[4];
    int idx; // Penanda jumlah data yang tersimpan

    // Method untuk menambah data buku ke dalam array
    void tambah(Buku03 b) {
        if (idx<listBuku.length) { // Cek apakah kapasitas array masih tersedia
            listBuku[idx] = b;     // Simpan data mahasiswa ke posisi index saat ini
            idx++;                 // Increment index untuk data berikutnya
        }else {
            System.out.println("Data sudah penuh"); // jika array penuh
        }
    }

    // Method untuk menampilkan seluruh data buku yang tersimpan dalam array
    void tampil() {
        System.out.println("=== Daftar Buku ===");
        for (int i = 0; i < idx; i++) { // Looping hanya sampai jumlah data yang terisi
            listBuku[i].tampilBuku(); // Memanggil method tampil dari setiap objek buku
        }
    }
}