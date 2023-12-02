import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;  

class Menu {
	static String[] makanan = { "Croissant", "Red Velvet", "Choux\t", "Flaky\t", "Shortcrust" };
	static Integer[] hargaMakanan = { 19000, 27000, 22000, 26000, 18000 };

	static String[] minuman = { "Iced Americano", "Green Tea Frappucino", "Air Mineral\t", "Vanilla Frappucino",
			"Chamomile Hot Tea" };
	static Integer[] hargaMinuman = { 23000, 27000, 10000, 28000, 32000 };
	static double subTotal = 0;
	static double totalBayar = 0;
	static double totalBayarKeseluruhan = 0;
	static double disc = 0.10;
	static double tax = 0.10;
	static int totalOrder = 0;
	static int maxOrder = 4;
	static double bayarPelayanan = 20000;
	static List<String> simpanPesanan = new ArrayList<>();
	static List<Double> simpanHarga = new ArrayList<>();
	static List<Double> simpanHargaTotal = new ArrayList<>();
	static List<Integer> totalItem = new ArrayList<>();
	static boolean nextOrder = true;

	static Scanner scan = new Scanner(System.in);

	public static void showMenuUtama() {
		System.out.println("=====Rendezvous Coffee====");
		System.out.println("1. Ubah Menu");
		System.out.println("2. Memesan Menu");
		System.out.print("Pilih: ");
	}
	
	public static void showMakanan() {
		System.out.println("=====1. Makanan=====");
		System.out.println("Menu" + "\t\t\tHarga");
		for (int i = 0; i < makanan.length; i++)
			System.out.println((i + 1) + "." + makanan[i] + "\t\t" + hargaMakanan[i]);
		System.out.println("=====================");
		
	}
	
	public static void showMinuman() {
		System.out.println("=====2. Minuman=====");
		System.out.println("Menu" + "\t\t\tHarga");
		for (int i = 0; i < minuman.length; i++)
			System.out.println((i + 1) + "." + minuman[i] + "\t" + hargaMinuman[i]);
		System.out.println("======================");

	}
	
	public static void pilihOpsi() {
		System.out.println("======================");
		// System.out.println("Pilih opsi:");
		System.out.println("1. Tambah Menu");
		System.out.println("2. Edit Menu");
		System.out.println("3. Hapus Menu");

	}

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

	public static void tambahOpsiMakanan(){
		System.out.println("======================");
		
		System.out.print("Nama Menu: ");
		String namaMenuBaru = scan.next();
		makanan = addNamaMenu(makanan, namaMenuBaru);

		System.out.print("Harga: ");
		int hargaMenuBaru = scan.nextInt();
		hargaMakanan = addHargaMenu(hargaMakanan, hargaMenuBaru);

		System.out.println("Menu "+namaMenuBaru+" berhasil ditambahkan.");
	}

	public static void ubahOpsiMakanan(){
		System.out.println("======================");
		showMakanan();
		System.out.print("Pilih menu yang akan diubah: ");
		int pilihMenu = scan.nextInt();
		
		System.out.println("======================");
		System.out.print("Masukkan nama menu baru: ");
		String namaMenu = scan.next();
		System.out.print("Masukkan harga menu baru: ");
		int hargaMenu = scan.nextInt();

		makanan[pilihMenu-1] = namaMenu;
		hargaMakanan[pilihMenu-1] = hargaMenu;
	}

	public static void hapusOpsiMakanan(){
		System.out.println("======================");
		showMakanan();
		System.out.print("Pilih menu yang akan dihapus: ");
		int pilihMenu = scan.nextInt();

		String namaMenu = makanan[pilihMenu-1];
		makanan = removeTheElementString(makanan, pilihMenu-1);
		hargaMakanan = removeTheElementInteger(hargaMakanan, pilihMenu-1);
		System.out.println("Menu "+namaMenu+" berhasil dihapus.");
	}

	public static void tambahOpsiMinuman(){
		System.out.println("======================");
		
		System.out.print("Nama Menu: ");
		String namaMenuBaru = scan.next();
		minuman = addNamaMenu(minuman, namaMenuBaru);

		System.out.print("Harga: ");
		int hargaMenuBaru = scan.nextInt();
		hargaMinuman = addHargaMenu(hargaMinuman, hargaMenuBaru);
		
		System.out.println("Menu "+namaMenuBaru+" berhasil ditambahkan.");
	}

	public static void ubahOpsiMinuman(){
		System.out.println("======================");
		showMinuman();
		System.out.print("Pilih menu yang akan diubah: ");
		int pilihMenu = scan.nextInt();
		
		System.out.println("======================");
		System.out.print("Masukkan nama menu baru: ");
		String namaMenu = scan.next();
		System.out.print("Masukkan harga menu baru: ");
		int hargaMenu = scan.nextInt();

		minuman[pilihMenu-1] = namaMenu;
		hargaMinuman[pilihMenu-1] = hargaMenu;
	}

	public static void hapusOpsiMinuman(){
		System.out.println("======================");
		showMinuman();
		System.out.print("Pilih menu yang akan dihapus: ");
		int pilihMenu = scan.nextInt();

		String namaMenu = minuman[pilihMenu-1];
		minuman = removeTheElementString(minuman, pilihMenu-1);
		hargaMinuman = removeTheElementInteger(hargaMinuman, pilihMenu-1);
		System.out.println("Menu "+namaMenu+" berhasil dihapus.");
	}
	
	public static void editMenuMakanan(){
		try{
			showMakanan();
			pilihOpsi();
			System.out.print("Pilih opsi: ");
			int pilihOpsi = scan.nextInt();
			switch (pilihOpsi) {
			case 1:
				tambahOpsiMakanan();
				orderPesanan();
				break;
			case 2:
				ubahOpsiMakanan();
				orderPesanan();
				break;
			case 3:
				hapusOpsiMakanan();
				orderPesanan();
				break;
			default:
				System.out.println("Mohon maaf pesanan anda tidak ada dalam opsi.");
				scan.nextLine();
				editMenuMakanan();
			}

		}catch(InputMismatchException ex){
			System.out.println("Mohon maaf pilihan anda tidak ada dalam opsi.");
			scan.nextLine();
			editMenuMakanan();
		}
	}

	public static void editMenuMinuman(){
		try{
			showMinuman();
			pilihOpsi();
			System.out.print("Pilih opsi: ");
			int pilihOpsi = scan.nextInt();
			switch (pilihOpsi) {
			case 1:
				tambahOpsiMinuman();
				orderPesanan();
				break;
			case 2:
				ubahOpsiMinuman();
				orderPesanan();
				break;
			case 3:
				hapusOpsiMinuman();
				orderPesanan();
				break;
			default:
				
			}

		}catch(InputMismatchException ex){
			System.out.println("Mohon maaf pilihan anda tidak ada dalam opsi.");
			scan.nextLine();
			editMenuMinuman();
		}
	}
	
	public static void editMenu() {
		showMenu();
		System.out.print("Pilih kategori menu yang akan diubah: ");
		int pilih = 0;
		do {
			int kategori = scan.nextInt();
			switch (kategori) {
			case 1:
				editMenuMakanan();
				break;
			case 2:
				editMenuMinuman();
				break;
			case 3:
				showMenuUtama();
				break;
			default:
				System.out.println("Kategori yang anda pilih tidak ada.");
				editMenu();
			}
			
		} while (pilih != 3);
	}

	public static void showMenu() {
		System.out.println("=====Rendezvous Coffee=====");
		System.out.println("1. Makanan");
		System.out.println("2. Minuman");
		System.out.println("3. Kembali ke Menu Utama");
	}

	public static void tambahOrder() {
		System.out.println("Tambah pesanan anda?");
		System.out.println("1. Ya");
		System.out.println("2. Tidak");
		System.out.print("Pilih: ");

		int pilihOrder = scan.nextInt();

		if (pilihOrder == 1) {
			orderPesanan();
		} else {
			cetakBills();
		}
	}

	public static void pesanMakanan(){
		try{
			showMakanan();
			System.out.print("Silakan pilih makanan: ");
			int listMakanan = scan.nextInt();
			
			switch (listMakanan) {
			case 1:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(makanan[0] + ": ");
				int a = scan.nextInt();
				String order = makanan[listMakanan - 1];
				double harga = hargaMakanan[listMakanan - 1];
				double totalHarga = harga * a;
				simpanPesanan.add(order);
				simpanHarga.add(harga);
				totalItem.add(a);
				simpanHargaTotal.add(totalHarga);
				subTotal += harga * a;
				tambahOrder();
				break;
			case 2:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(makanan[1] + ": ");
				int b = scan.nextInt();
				String order1 = makanan[listMakanan - 1];
				double harga1 = hargaMakanan[listMakanan - 1];
				double totalHarga1 = harga1 * b;
				simpanPesanan.add(order1);
				simpanHarga.add(harga1);
				totalItem.add(b);
				simpanHargaTotal.add(totalHarga1);
				subTotal += harga1 * b;
				tambahOrder();
				break;
			case 3:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(makanan[2] + ": ");
				int c = scan.nextInt();
				String order2 = makanan[listMakanan - 1];
				double harga2 = hargaMakanan[listMakanan - 1];
				double totalHarga2 = harga2 * c;
				simpanPesanan.add(order2);
				simpanHarga.add(harga2);
				totalItem.add(c);
				simpanHargaTotal.add(totalHarga2);
				subTotal += harga2 * c;
				tambahOrder();
				break;
			case 4:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(makanan[3] + ": ");
				int d = scan.nextInt();
				String order3 = makanan[listMakanan - 1];
				double harga3 = hargaMakanan[listMakanan - 1];
				double totalHarga3 = harga3 * d;
				simpanPesanan.add(order3);
				simpanHarga.add(harga3);
				totalItem.add(d);
				simpanHargaTotal.add(totalHarga3);
				subTotal += harga3 * d;
				tambahOrder();
				break;
			case 5:
				System.out.println("Masukkan jumlah pesanan ");
				System.out.print(makanan[4] + ": ");
				int e = scan.nextInt();
				String order4 = makanan[listMakanan - 1];
				double harga4 = hargaMakanan[listMakanan - 1];
				double totalHarga4 = harga4 * e;
				simpanPesanan.add(order4);
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
		}catch(InputMismatchException ex){
			System.out.println("Mohon maaf pesanan anda tidak ada dalam daftar makanan.");
			scan.nextLine();
			pesanMakanan();
		}
	}

	public static void pesanMinuman(){
		try{
			showMinuman();
			System.out.print("Silakan pilih minuman: ");
			int listMinuman = scan.nextInt();
			switch (listMinuman) {
			case 1:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(minuman[0] + ": ");
				int a = scan.nextInt();
				String order = minuman[listMinuman - 1];
				double harga = hargaMinuman[listMinuman - 1];
				double totalHarga = harga * a;
				simpanPesanan.add(order);
				simpanHarga.add(harga);
				totalItem.add(a);
				simpanHargaTotal.add(totalHarga);
				subTotal += harga * a;
				tambahOrder();
				break;
			case 2:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(minuman[1] + ": ");
				int b = scan.nextInt();
				String order1 = minuman[listMinuman - 1];
				double harga1 = hargaMinuman[listMinuman - 1];
				double totalHarga1 = harga1 * b;
				simpanPesanan.add(order1);
				simpanHarga.add(harga1);
				totalItem.add(b);
				simpanHargaTotal.add(totalHarga1);
				subTotal += harga1 * b;
				tambahOrder();
				break;
			case 3:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(minuman[2] + ": ");
				int c = scan.nextInt();
				String order2 = minuman[listMinuman - 1];
				double harga2 = hargaMinuman[listMinuman - 1];
				double totalHarga2 = harga2 * c;
				simpanPesanan.add(order2);
				simpanHarga.add(harga2);
				totalItem.add(c);
				simpanHargaTotal.add(totalHarga2);
				subTotal += harga2 * c;
				tambahOrder();
				break;
			case 4:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(minuman[3] + ": ");
				int d = scan.nextInt();
				String order3 = minuman[listMinuman - 1];
				double harga3 = hargaMinuman[listMinuman - 1];
				double totalHarga3 = harga3 * d;
				simpanPesanan.add(order3);
				simpanHarga.add(harga3);
				totalItem.add(d);
				simpanHargaTotal.add(totalHarga3);
				subTotal += harga3 * d;
				tambahOrder();
				break;
			case 5:
				System.out.println("Masukkan jumlah pesanan: ");
				System.out.print(minuman[4] + ": ");
				int e = scan.nextInt();
				String order4 = minuman[listMinuman - 1];
				double harga4 = hargaMinuman[listMinuman - 1];
				double totalHarga4 = harga4 * e;
				simpanPesanan.add(order4);
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
		}catch(InputMismatchException ex){
			System.out.println("Mohon maaf pesanan anda tidak ada dalam daftar minuman.");
			scan.nextLine();
			pesanMinuman();
		}
	}

	public static void orderPesanan() {
		totalOrder++;
		showMenuUtama();
		int pilih = scan.nextInt();
	
		if (pilih == 1) {
			editMenu();
		} else if (pilih == 2) {
			showMenu();
			System.out.print("Silakan pilih kategori:");
			int kategori = scan.nextInt();
			if (kategori == 1) {
				pesanMakanan();
			} else if (kategori == 2) {
				pesanMinuman();
			} else {
				System.out.println("Mohon maaf pilihan anda tidak ada dalam kategori.");
				orderPesanan();
			}
		} else {
			System.out.println("Mohon maaf pilihan anda tidak ada.");
		}
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

	public static void cetakBills() {
		hitungTotal();
		double pajak = totalBayar * tax;
		double diskon = totalBayar * disc;

		System.out.println("=====Rendezvous Coffee=====");
		System.out.println("Daftar Pesanan" + "\t\tHarga" + "\t\tJumlah" + "\t\tTotal Harga");
		for (int i = 0; i < simpanPesanan.size(); i++) {
			System.out.println(simpanPesanan.get(i) + "\tRp. " + simpanHarga.get(i) + "\t\t " + totalItem.get(i)
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
		System.out.println("Dapatkan diskon 10% setiap minimal pembelian Rp. 100000");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		orderPesanan();
	}

}