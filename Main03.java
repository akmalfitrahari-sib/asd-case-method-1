import java.util.Scanner; // Import class Scanner untuk input dari user
public class Main03 {

    // Method untuk menampilkan menu
    public static void tampilkanMenu(){
        System.out.println("\n=== SISTEM PEMINJAMAN RUANG BACA JTI ===");
        System.out.println("1. Tampilkan Mahasiswa");
        System.out.println("2. Tampilkan Buku");
        System.out.println("3. Tampilkan Peminjaman");
        System.out.println("4. Urutkan berdasarkan denda");
        System.out.println("5. Cari berdasarkan NIM");
        System.out.println("0. Keluar");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Membuat objek scanner
        int pilihanMenu = 0; // Variabel untuk menyimpan pilihan user

        // Membuat dan mengisi data mahasiswa
        ListMahasiswa03 listMhs = new ListMahasiswa03();
        Mahasiswa03 m1 = new Mahasiswa03("22001", "Andi", "Teknik Informatika");
        Mahasiswa03 m2 = new Mahasiswa03("22002", "Budi", "Teknik Informatika");
        Mahasiswa03 m3 = new Mahasiswa03("22003", "Citra", "Sistem Informasi Bisnis");
        listMhs.tambah(m1);
        listMhs.tambah(m2);
        listMhs.tambah(m3);

        // Membuat dan mengisi data buku
        ListBuku03 listBuku = new ListBuku03();
        Buku03 b1 = new Buku03("B001", "Algoritma", 2020);
        Buku03 b2 = new Buku03("B002", "Basis Data", 2019);
        Buku03 b3 = new Buku03("B003", "Pemrograman", 2021);
        Buku03 b4 = new Buku03("B004", "Fisika", 2024);
        listBuku.tambah(b1);
        listBuku.tambah(b2);
        listBuku.tambah(b3);
        listBuku.tambah(b4);

        // Membuat dan mengisi data peminjaman
        ListPeminjaman03 listPeminjaman = new ListPeminjaman03();
        Peminjaman03 p1 = new Peminjaman03(m1, b1, 7);
        Peminjaman03 p2 = new Peminjaman03(m2, b2, 3);
        Peminjaman03 p3 = new Peminjaman03(m3, b3, 10);
        Peminjaman03 p4 = new Peminjaman03(m3, b4, 6);
        Peminjaman03 p5 = new Peminjaman03(m1, b2, 4);
        listPeminjaman.tambah(p1);
        listPeminjaman.tambah(p2);
        listPeminjaman.tambah(p3);
        listPeminjaman.tambah(p4);
        listPeminjaman.tambah(p5);
        
        // Perulangan menu sampai user memilih keluar
        do {
            tampilkanMenu();
            System.out.print("Pilih menu: ");
            pilihanMenu = sc.nextInt(); // Input pilihan menu
            sc.nextLine(); // Membersihkan newline

            switch (pilihanMenu) {
                case 1 -> listMhs.tampil();  // Menampilkan data mahasiswa
                case 2 -> listBuku.tampil(); // Menampilkan data buku
                case 3 -> listPeminjaman.tampil("=== Data Peminjaman ==="); // Menampilkan data peminjaman
                case 4 -> {
                    listPeminjaman.insertionSort(); // Mengurutkan berdasarkan denda terbesar (descending)
                    listPeminjaman.tampil("=== Data setelah diurutkan (Denda Terbesar) ==="); // Menampilkan hasil setelah sorting
                }
                case 5 -> {
                    System.out.print("Masukkan NIM: ");
                    String cari = sc.nextLine(); // Input NIM yang dicari
                    listPeminjaman.insertionSortNim(); // Data harus diurutkan dulu sebelum binary search
                    int pos = listPeminjaman.findBinarySearch(cari, 0, listMhs.idx -1);  // Mencari posisi data berdasarkan NIM
                    listPeminjaman.tampilDataSearch(cari, pos); // Menampilkan hasil pencarian
                }
                case 0 -> System.out.println("Program selesai."); // Keluar program
                default -> System.out.println("Pilihan tidak valid.");
            }
        
        } while (pilihanMenu != 0); // Berhenti jika user pilih 0
    }
}
