public class ListPeminjaman03 {
    // Array untuk menyimpan beberapa object Peminjaman03 (Maks 5 data)
    Peminjaman03 [] listPinjam = new Peminjaman03[5];
    int idx; // Penanda jumlah data yang tersimpan

    // Method untuk menambah data peminjaman ke dalam array
    void tambah(Peminjaman03 p){
        if (idx<listPinjam.length) { // Cek apakah kapasitas array masih tersedia
            listPinjam[idx] = p;     // Simpan data peminjaman ke posisi index saat ini
            idx++;                   // Increment index untuk data berikutnya
        } else {
            System.out.println("Data sudah penuh"); // jika array penuh
        }
    }

    // Method untuk menampilkan seluruh data peminjaman yang tersimpan dalam array
    void tampil(String judul) {
        System.out.println(judul);        // Menampilkan judul tampilan
        for (int i = 0; i < idx; i++) {   // Looping sesuai jumlah data
            listPinjam[i].hitungDenda();  // Menghitung denda sebelum ditampilkan
            listPinjam[i].tampilPeminjaman(); // Menampilkan data peminjaman
        }
    }

    // Mengurutkan berdasarkan denda (terbesar)
    void insertionSort() {
        //Menghitung semua denda terlebih dahulu
        for (int i = 0; i < idx; i++) {
            listPinjam[i].hitungDenda();
        }

        // Setelah itu melakukan sorting descending (besar - kecil)
        for (int i = 0; i < idx; i++) {
            Peminjaman03 temp = listPinjam[i]; // Simpan sementara data
            int j = i;

            // Geser data jika denda sebelumnya lebih kecil (descending)
            while (j > 0 && listPinjam[j-1].denda < temp.denda) {
                listPinjam[j] = listPinjam [j-1];
                j--;
            }
            listPinjam[j] = temp; // Tempatkan data pada posisi yang tepat
        }
    }

    // Method untuk mengurutkan data berdasarkan Nama (ascending)
    void insertionSortNama() {
        for (int i = 1; i < idx; i++) {
            Peminjaman03 temp = listPinjam[i]; // Simpan sementara data
            int j = i;

            // Geser data jika nama sebelumnya lebih besar (ascending)
            while (j > 0 && listPinjam[j-1].mhs.nama.compareTo(temp.mhs.nama) > 0) {
                listPinjam[j] = listPinjam [j-1];
                j--;
            }
            listPinjam[j] = temp; // Tempatkan data pada posisi yang tepat
        }
    }

    // Method binary search untuk mencari data berdasarkan Nama
    int findBinarySearch(String cari, int left, int right) {
        int mid;
        if (right >= left) { // Selama masih ada rentang pencarian
            mid = (left + right)/2; // Menentukan indeks tengah

            // Jika data ditemukan
            if (cari.equalsIgnoreCase(listPinjam[mid].mhs.nama)) {
                return (mid);
            }
            // Jika data tengah lebih besar, cari ke kiri
            else if (listPinjam[mid].mhs.nama.compareToIgnoreCase(cari) > 0) {
                return findBinarySearch(cari, left, mid-1);
            }
            // Jika lebih kecil, cari ke kanan
            else {
                return findBinarySearch(cari, mid+1, right);
            }
        }
        return -1; // Jika data tidak ditemukan
    }

    // Method untuk menampilkan hasil pencarian berdasarkan Nama
    void tampilDataSearch(String nama, int pos) {
        if (pos !=-1) { // Jika data ditemukan
            
            //cek ke kiri
            int i = pos;
            while (i >= 0 && listPinjam[i].mhs.nama.equalsIgnoreCase(nama)) {
                i--;
            }
            i++; // kembali ke posisi awal yang cocok

            // menampilkan semua data yang sama
            while (i < idx && listPinjam[i].mhs.nama.equalsIgnoreCase(nama)) {
                Peminjaman03 p = listPinjam[i];
                p.hitungDenda(); // Memastikan denda sudah dihitung

                System.out.println(p.mhs.nama + " | " + p.buku.judul + " | Lama: " + p.lamaPinjam 
            + " | Terlambat: " + p.terlambat + " | Denda: " + p.denda);

                i++;
            }
        }
        else {
            System.out.println("Data tidak ditemukan"); // Jika tidak ditemukan
        }
    }
}