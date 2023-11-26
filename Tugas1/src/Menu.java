import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;  

abstract class MenuItem {
	protected String nama, kategori;
	protected double harga;
	public abstract void tampilMenu();
}

class Makanan extends MenuItem {
	String[] menuMakanan = {"Croissant", "Red Velvet", "Choux", "Flaky", "Shortcrust"};
	Integer[] hargaMakanan = { 19000, 27000, 22000, 26000, 18000 }; 
			
	public void tampilMenu() {
		System.out.println("====== Makanan ======");
		for (int i = 0; i < menuMakanan.length; i++) {
			System.out.println("[" + (i+1) +"]" + menuMakanan[i] + " Rp. " + hargaMakanan[i]);
		}
		System.out.println("========================");
	}
}

class Minuman extends MenuItem {
	static String[] menuMinuman = { "Iced Americano", "Green Tea Frappucino", "Air Mineral\t", "Vanilla Frappucino",
	"Chamomile Hot Tea" };
	static Integer[] hargaMinuman = { 23000, 27000, 10000, 28000, 32000 };
	
	public void tampilMenu() {
		System.out.println("====== Minuman ======");
		for (int i = 0; i < menuMinuman.length; i++) {
			System.out.println("[" + (i+1) +"]" + menuMinuman[i] + " Rp. " + hargaMinuman[i]);
		}
		System.out.println("========================");
	}
}

class Diskon extends MenuItem {
	double diskon = 0.10;
	public void tampilMenu() {
		System.out.println("Dapatkan diskon 10% setiap minimal pembelian Rp. 100000");
	}
}

class EditMenu {
	static Scanner scan = new Scanner(System.in);
	
	static Makanan showMakanan = new Makanan();
	static Minuman showMinuman = new Minuman();
	
	static String[] makanan = showMakanan.menuMakanan;
	static Integer[] hargaMakanan = showMakanan.hargaMakanan;
	
	static String[] minuman = showMinuman.menuMinuman;
	static Integer[] hargaMinuman = showMinuman.hargaMinuman;
	
	public static String[] addNamaMenu(String arr[], String x) 
	{ 
			List<String> arrlist = new ArrayList<String>(Arrays.asList(arr)); 
			arrlist.add(x); 
			arr = arrlist.toArray(arr); 
	
			return arr; 
	} 
	
	public static Integer[] addHargaMenu(Integer arr[], int x) 
	{ 
			List<Integer> arrlist = new ArrayList<Integer>(Arrays.asList(arr)); 
			arrlist.add(x); 
			arr = arrlist.toArray(arr); 
	 
			return arr; 
	} 
	
	public static String[] removeTheElementString(String[] arr, int index) 
	{ 
			String[] anotherArray = new String[arr.length - 1]; 

			for (int i = 0, k = 0; i < arr.length; i++) { 
					if (i == index) { 
							continue; 
					} 

					anotherArray[k++] = arr[i]; 
			} 

			return anotherArray; 
	} 

	public static Integer[] removeTheElementInteger(Integer[] arr, int index) 
	{ 
			Integer[] anotherArray = new Integer[arr.length - 1]; 

			for (int i = 0, k = 0; i < arr.length; i++) { 
					if (i == index) { 
							continue; 
					} 

					anotherArray[k++] = arr[i]; 
			} 

			return anotherArray; 
	} 
	
	public static void tambahMenuMakanan() {
		showMakanan.tampilMenu();
		System.out.print("Masukkan nama menu baru: ");
		String namaMenu = scan.next();
	}
	
	public static void hapusMenuMakanan() {
		showMakanan.tampilMenu();
		System.out.print("Pilih menu yang akan dihapus: ");
		int pilihMenu = scan.nextInt();
		String namaMenu = makanan[pilihMenu-1];
		makanan = removeTheElementString(makanan, pilihMenu-1);
		hargaMakanan = removeTheElementInteger(hargaMakanan, pilihMenu-1);
		System.out.println("Menu "+namaMenu+" berhasil dihapus.");
		System.out.println("Menu makanan berhasil diubah.");
	}
	
	public static void ubahMenuMakanan() {
		showMakanan.tampilMenu();
		System.out.print("Pilih menu yang akan diubah: ");
		int pilihMenu = scan.nextInt();
		System.out.print("Masukkan nama menu baru: ");
		String namaMenu = scan.next();
		System.out.print("Masukkan harga menu baru: ");
		int hargaMenu = scan.nextInt();
		
		makanan[pilihMenu-1] = namaMenu;
		hargaMakanan[pilihMenu-1] = hargaMenu;
		System.out.println("Menu makanan berhasil diubah.");
	}
	
	public static void tambahMenuMinuman() {
		showMinuman.tampilMenu();
	}
	
	public static void hapusMenuMinuman() {
		showMinuman.tampilMenu();
		
	}
	
	public static void ubahMenuMinuman() {
		showMinuman.tampilMenu();
	}
	
}

class Pesanan {
	static Scanner scan = new Scanner(System.in);
	
	static Makanan showMakanan = new Makanan();
	static Minuman showMinuman = new Minuman();
	static Diskon infoDiskon = new Diskon();
	static MainMenu mainMenu = new MainMenu();
	static Diskon potongDiskon = new Diskon();
	
	static List<String> itemPesanan = new ArrayList<>();
	static List<Double> simpanHarga = new ArrayList<>();
	static List<Double> simpanHargaTotal = new ArrayList<>();
	static List<Integer> totalItem = new ArrayList<>();
	static double subTotal = 0;
	static double totalBayar = 0;
	static double totalBayarKeseluruhan = 0;
	static double tax = 0.10; 
	static double bayarPelayanan = 20000;
	static double disc = potongDiskon.diskon;

	
	public static void pesanMakanan() {
		try {
			showMakanan.tampilMenu();
			System.out.print("Silakan masukan pesanan Anda: ");
			int listMakanan = scan.nextInt();
			switch (listMakanan) {
			case 1:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(showMakanan.menuMakanan[0] + ": ");
				int a = scan.nextInt();
				String order = showMakanan.menuMakanan[listMakanan - 1];
				double harga = showMakanan.hargaMakanan[listMakanan - 1];
				double totalHarga = harga * a;
				itemPesanan.add(order);
				simpanHarga.add(harga);
				totalItem.add(a);
				simpanHargaTotal.add(totalHarga);
				subTotal += harga * a;
				tambahOrder();
				break;
			case 2:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(showMakanan.menuMakanan[1] + ": ");
				int b = scan.nextInt();
				String order1 = showMakanan.menuMakanan[listMakanan - 1];
				double harga1 = showMakanan.hargaMakanan[listMakanan - 1];
				double totalHarga1 = harga1 * b;
				itemPesanan.add(order1);
				simpanHarga.add(harga1);
				totalItem.add(b);
				simpanHargaTotal.add(totalHarga1);
				subTotal += harga1 * b;
				tambahOrder();
				break;
			case 3:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(showMakanan.menuMakanan[2] + ": ");
				int c = scan.nextInt();
				String order2 = showMakanan.menuMakanan[listMakanan - 1];
				double harga2 = showMakanan.hargaMakanan[listMakanan - 1];
				double totalHarga2 = harga2 * c;
				itemPesanan.add(order2);
				simpanHarga.add(harga2);
				totalItem.add(c);
				simpanHargaTotal.add(totalHarga2);
				subTotal += harga2 * c;
				tambahOrder();
				break;
			case 4:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(showMakanan.menuMakanan[3] + ": ");
				int d = scan.nextInt();
				String order3 = showMakanan.menuMakanan[listMakanan - 1];
				double harga3 = showMakanan.hargaMakanan[listMakanan - 1];
				double totalHarga3 = harga3 * d;
				itemPesanan.add(order3);
				simpanHarga.add(harga3);
				totalItem.add(d);
				simpanHargaTotal.add(totalHarga3);
				subTotal += harga3 * d;
				tambahOrder();
				break;
			case 5:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(showMakanan.menuMakanan[4] + ": ");
				int e = scan.nextInt();
				String order4 = showMakanan.menuMakanan[listMakanan - 1];
				double harga4 = showMakanan.hargaMakanan[listMakanan - 1];
				double totalHarga4 = harga4 * e;
				itemPesanan.add(order4);
				simpanHarga.add(harga4);
				totalItem.add(e);
				simpanHargaTotal.add(totalHarga4);
				subTotal += harga4 * e;
				tambahOrder();
				break;
			default:
				System.out.println("Mohon maaf pesanan anda tidak ada dalam daftar makanan.");
				scan.nextLine();
				pesanMakanan();
			}
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			pesanMakanan();
		}
	}
	
	public static void pesanMinuman() {
		try {
			showMinuman.tampilMenu();
			System.out.print("Silakan masukan pesanan Anda: ");
			int listMinuman = scan.nextInt();
			switch (listMinuman) {
			case 1:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(showMinuman.menuMinuman[0] + ": ");
				int a = scan.nextInt();
				String order = showMinuman.menuMinuman[listMinuman - 1];
				double harga = showMinuman.hargaMinuman[listMinuman - 1];
				double totalHarga = harga * a;
				itemPesanan.add(order);
				simpanHarga.add(harga);
				totalItem.add(a);
				simpanHargaTotal.add(totalHarga);
				subTotal += harga * a;
				tambahOrder();
				break;
			case 2:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(showMinuman.menuMinuman[1] + ": ");
				int b = scan.nextInt();
				String order1 = showMinuman.menuMinuman[listMinuman - 1];
				double harga1 = showMinuman.hargaMinuman[listMinuman - 1];
				double totalHarga1 = harga1 * b;
				itemPesanan.add(order1);
				simpanHarga.add(harga1);
				totalItem.add(b);
				simpanHargaTotal.add(totalHarga1);
				subTotal += harga1 * b;
				tambahOrder();
				break;
			case 3:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(showMinuman.menuMinuman[2] + ": ");
				int c = scan.nextInt();
				String order2 = showMinuman.menuMinuman[listMinuman - 1];
				double harga2 = showMinuman.hargaMinuman[listMinuman - 1];
				double totalHarga2 = harga2 * c;
				itemPesanan.add(order2);
				simpanHarga.add(harga2);
				totalItem.add(c);
				simpanHargaTotal.add(totalHarga2);
				subTotal += harga2 * c;
				tambahOrder();
				break;
			case 4:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(showMinuman.menuMinuman[3] + ": ");
				int d = scan.nextInt();
				String order3 = showMinuman.menuMinuman[listMinuman - 1];
				double harga3 = showMinuman.hargaMinuman[listMinuman - 1];
				double totalHarga3 = harga3 * d;
				itemPesanan.add(order3);
				simpanHarga.add(harga3);
				totalItem.add(d);
				simpanHargaTotal.add(totalHarga3);
				subTotal += harga3 * d;
				tambahOrder();
				break;
			case 5:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(showMinuman.menuMinuman[4] + ": ");
				int e = scan.nextInt();
				String order4 = showMinuman.menuMinuman[listMinuman - 1];
				double harga4 = showMinuman.hargaMinuman[listMinuman - 1];
				double totalHarga4 = harga4 * e;
				itemPesanan.add(order4);
				simpanHarga.add(harga4);
				totalItem.add(e);
				simpanHargaTotal.add(totalHarga4);
				subTotal += harga4 * e;
				tambahOrder();
				break;
			default:
				System.out.println("Mohon maaf pesanan anda tidak ada dalam daftar minuman.");
				scan.nextLine();
				pesanMinuman();
			}
		} catch(InputMismatchException ex){
			System.out.println("Mohon maaf pesanan anda tidak ada dalam daftar minuman.");
			scan.nextLine();
			pesanMinuman();
		}
	}
	
	public static void orderPesanan() {
		try {
			mainMenu.showKategori();
			int pilihKategori = scan.nextInt();
			switch (pilihKategori) {
			case 1:
				pesanMinuman();
				break;
			case 2:
				pesanMakanan();
				break;
			case 3:
				
				break;
			default:
					
			}
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			orderPesanan();
		}
	}
	
	public static void cetakBills() {
		hitungTotal();
		double pajak = totalBayar * tax;
		double diskon = totalBayar * disc;

		System.out.println("=====Rendezvous Coffee=====");
		System.out.println("Daftar Pesanan" + "\t\tHarga" + "\t\tJumlah" + "\t\tTotal Harga");
		for (int i = 0; i < itemPesanan.size(); i++) {
			System.out.println(itemPesanan.get(i) + "\tRp. " + simpanHarga.get(i) + "\t\t " + totalItem.get(i)
					+ "\t\tRp. " + simpanHargaTotal.get(i));
		}
		System.out.println("==========================");
		System.out.println("Total: Rp. " + totalBayar);
		System.out.println("Biaya pelayanan: Rp. " + bayarPelayanan);
		System.out.println("PPN(10%): Rp. " + pajak);
		if (totalBayar > 100000) {
			System.out.println("Diskon(10%): Rp. " + diskon);
		} else {
			System.out.println("Diskon(10%): Rp. -");
		}
		System.out.println("Total bayar: Rp. " + totalBayarKeseluruhan);
		System.out.println("==========================");
		System.out.println("Setiap pembelian dikenakan PPN sebesar 10%");
		infoDiskon.tampilMenu();
	}
	
	public static void hitungTotal() {
		totalBayar = subTotal;
		double pajak = totalBayar * tax;
		double diskon = totalBayar * disc;
		
		if (totalBayar > 100000) {
			totalBayarKeseluruhan = totalBayar + bayarPelayanan + pajak - diskon;
		} else {
			totalBayarKeseluruhan = totalBayar + bayarPelayanan + pajak;
		}
	}
	
	public static void tambahOrder() {
		try {
			System.out.println("Tambah pesanan anda?");
			System.out.println("1. Ya");
			System.out.println("2. Tidak");
			System.out.print("Pilih: ");

			int pilihOrder = scan.nextInt();
			
			switch (pilihOrder) {
			case 1:
				orderPesanan();
				break;
			case 2:
				cetakBills();
				break;
			default:
					
			}
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			tambahOrder();
		}
	}
}



class EditMenuScreen {
	static Scanner scan = new Scanner(System.in);
	static MainMenu kategori = new MainMenu();
	static EditMenu editMenu = new EditMenu();
	
	public static void tambahMenu() {
		try {
			kategori.showKategoriTemplate();
			System.out.print("Pilih kategori menu yang akan ditambah: ");
			int pilihKategori = scan.nextInt();
			switch (pilihKategori) {
			case 1:
				editMenu.tambahMenuMakanan();
				break;
			case 2:
				editMenu.tambahMenuMinuman();
				break;
			case 3:
				kategori.showEditKategori();
				break;
			default:
				
			}	
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			tambahMenu();
		}
	}
	
	public static void ubahMenu() {
		try {
			kategori.showKategoriTemplate();
			System.out.print("Pilih kategori menu yang akan ditambah: ");
			int pilihKategori = scan.nextInt();
			switch (pilihKategori) {
			case 1:
				editMenu.ubahMenuMakanan();
				break;
			case 2:
				editMenu.ubahMenuMinuman();
				break;
			case 3:
				kategori.showEditKategori();
				break;
			default:
				
			}	
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			tambahMenu();
		}
	}
	
	public static void hapusMenu() {
		try {
			kategori.showKategoriTemplate();
			System.out.print("Pilih kategori menu yang akan ditambah: ");
			int pilihKategori = scan.nextInt();
			switch (pilihKategori) {
			case 1:
				editMenu.hapusMenuMinuman();
				break;
			case 2:
				editMenu.hapusMenuMakanan();
				break;
			case 3:
				kategori.showEditKategori();
				break;
			default:
				
			}	
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			tambahMenu();
		}
	}
	
}


class MainMenu {
	static Scanner scan = new Scanner(System.in);
	static Pesanan pesanMenu = new Pesanan();
	static EditMenuScreen opsiMenu = new EditMenuScreen();
	
	public static void showKategoriTemplate() {
		System.out.println("====== Kategori ======");
		System.out.println("[1] Minuman");
		System.out.println("[2] Makanan");
		System.out.println("[3] Kembali");
		System.out.println("========================");
	}
	
	public static void mainScreen() {
		try {
			while (true) {
				System.out.println("=== Rendezvous Coffee ===");
				System.out.println("[1] Edit Menu");
				System.out.println("[2] Memesan Menu");
				System.out.println("[3] Keluar");
				System.out.println("========================");
				System.out.print("Pilih: ");
				int pilihMenu = scan.nextInt();
				switch (pilihMenu) {
				case 1:
					showEditKategori();
					break;
				case 2:
					showKategori();
					break;
				case 3:
					System.exit(0);
					break;
				default:
					
				}
			}
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			mainScreen();
		}
	}
	
	public static void showKategori() {
		try {
			showKategoriTemplate();
			System.out.print("Pilih kategori: ");
			int pilihKategori = scan.nextInt();
			switch (pilihKategori) {
			case 1:
				pesanMenu.pesanMinuman();
				break;
			case 2:
				pesanMenu.pesanMakanan();
				break;
			case 3:
				mainScreen();
				break;
			default:
				
			}	
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			showKategori();
		}
	}
	
	public static void showEditKategori() {
		try {
			System.out.println("====== Edit Menu ======");
			System.out.println("[1] Tambah Menu");
			System.out.println("[2] Ubah Menu");
			System.out.println("[3] Hapus Menu");
			System.out.println("[4] Kembali");
			System.out.println("========================");
			System.out.print("Pilih opsi: ");
			int pilihKategori = scan.nextInt();
			switch (pilihKategori) {
			case 1:
				opsiMenu.tambahMenu();
				break;
			case 2:
				opsiMenu.ubahMenu();
				break;
			case 3:
				opsiMenu.hapusMenu();
				break;
			case 4:
				mainScreen();
				break;
			default:
				
			}	
		} catch(InputMismatchException ex) {
			System.out.println("Mohon maaf pilihan Anda tidak ditemukan.");
			scan.nextLine();
			showEditKategori();
		}
	}
	
}


class Menu {
	ArrayList<String> itemMenu = new ArrayList<>();
	
	static MainMenu mainMenu = new MainMenu();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		mainMenu.mainScreen();
		
	}

}
