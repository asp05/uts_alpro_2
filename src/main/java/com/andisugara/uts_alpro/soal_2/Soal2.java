/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andisugara.uts_alpro.soal_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author andi
 */
public class Soal2 {

    private static ArrayList<Member> daftarMember = new ArrayList<Member>();
    private static ArrayList<Barang> daftarBarang = new ArrayList<Barang>();
    private static ArrayList<Barang> daftarBeli = new ArrayList<Barang>();

    public static void main() {
        Member member = new Member("KD-001", "Andi", "0834323423");
        Member member2 = new Member("KD-003", "Willy", "0834334");
        daftarMember.add(member);
        daftarMember.add(member2);

        Barang barang = new Barang("BRG-001", "Lampu", 12500);
        Barang barang2 = new Barang("BRG-002", "Terminal", 30000);
        daftarBarang.add(barang);
        daftarBarang.add(barang2);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Member");
            System.out.println("2. Tambah Barang");
            System.out.println("3. Lihat Daftar Member");
            System.out.println("4. Lihat Daftar Barang");
            System.out.println("5. Input Transaksi Pembelian");
            System.out.println("6. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tambahMember();
                    break;
                case 2:
                    tambahBarang();
                    break;
                case 3:
                    lihatDaftarMember();
                    break;
                case 4:
                    lihatDaftarBarang();
                    break;
                case 5:
                    inputPembelian();
                    break;
                case 6:
                    System.out.println("Terima kasih sudah menggunakan program kami!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 6);

        scanner.close();
    }

    private static void tambahMember() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kode member: ");
        String kodeMember = scanner.nextLine();
        System.out.print("Masukkan nama member: ");
        String namaMember = scanner.nextLine();
        System.out.print("Masukkan nomor telepon member: ");
        String nomorTelepon = scanner.nextLine();
        Member member = new Member(kodeMember, namaMember, nomorTelepon);
        daftarMember.add(member);
        System.out.println("Member berhasil ditambahkan!");
    }

    private static void tambahBarang() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kode barang: ");
        String kodeBarang = scanner.nextLine();
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Masukkan harga: ");
        String harga = scanner.nextLine();
        double hargaDouble = Double.parseDouble(harga);
        Barang barang = new Barang(kodeBarang, namaBarang, hargaDouble);
        daftarBarang.add(barang);
        System.out.println("Barang berhasil ditambahkan!");
    }

    private static void lihatDaftarMember() {
        if (daftarMember.isEmpty()) {
            System.out.println("Belum ada member yang terdaftar.");
        } else {
            System.out.println("Daftar member:");
            for (Member member : daftarMember) {
                System.out.println("Kode member: " + member.getKodeMember() + ", Nama member: " + member.getNama() + ", Nomor telepon: " + member.getNomorTelepon());
            }
        }
    }

    private static void lihatDaftarBarang() {
        if (daftarBarang.isEmpty()) {
            System.out.println("Belum ada barang yang terdaftar.");
        } else {
            System.out.println("Daftar Barang:");
            for (Barang barang : daftarBarang) {
                System.out.println("Kode barang: " + barang.getKodeBarang() + ", Nama barang: " + barang.getNama() + ", harga: " + barang.getHarga());
            }
        }
    }

    private static void inputPembelian() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Apakah pembeli adalah member? (y/n): ");
        String jawaban = scanner.nextLine();
        boolean isMember = jawaban.equalsIgnoreCase("y");
        String kodeMember = null;
        String namaMember = null;
        if (isMember == true) {
            boolean existMember = false;
            do {
                System.out.print("Masukan kode member: ");
                String inputKodeMember = scanner.nextLine();
                Member memberDitemukan = daftarMember.stream()
                        .filter(member -> member.getKodeMember().equals(inputKodeMember))
                        .findFirst()
                        .orElse(null);
                if (memberDitemukan != null) {
                    existMember = true;
                    kodeMember = memberDitemukan.getKodeMember();
                    namaMember = memberDitemukan.getNama();
                } else {
                    existMember = false;
                }
            } while (existMember == false);

        } else {
            System.out.print("Masukan nama pembeli: ");
            kodeMember = "";
            namaMember = scanner.nextLine();
        }

        beliBarang();

//
//        System.out.println("\nTotal pembelian: " + totalPembelian);
//        System.out.println("Diskon: " + diskon);
//        System.out.println("Total bayar: " + totalBayar);
        System.out.println("============ INVOICE ALIZWELL============");
        System.out.println("Kode Member: " + kodeMember);
        System.out.println("Nama Member: " + namaMember);
        System.out.println("Apakah member: " + (isMember ? "Ya" : "Tidak"));
        System.out.println("================================================================");
        System.out.printf("%-10s%-20s%-10s%-10s%-10s\n", "Kode", "Nama Barang", "Harga", "Qty", "Total");
        System.out.println("================================================================");
        double totalHarga = 0;
        for (Barang barang : daftarBeli) {
            System.out.printf("%-10s%-20s%-10.2f%-10d%-10.2f\n", barang.getKodeBarang(), barang.getNama(), barang.getHarga(), barang.getQty(), barang.getTotal());
            totalHarga += barang.getTotal();
        }

        double diskon = hitungDiskon(totalHarga, isMember);
        double totalBayar = totalHarga - diskon;

        System.out.println("================================================================");
        System.out.printf("%-30s%-10.2f\n", "Total Harga", totalHarga);
        System.out.printf("%-30s%-10.2f\n", "Diskon", diskon);
        System.out.println("================================================================");
        System.out.printf("%-30s%-10.2f\n", "Grand Total", totalBayar);

        System.out.println("================================================================");
        daftarBeli.removeAll(daftarBeli);
    }

    private static void beliBarang() {
        Scanner scanner = new Scanner(System.in);
        lihatDaftarBarang();

        Barang barang = null;
        do {
            System.out.print("Masukkan kode barang: ");
            String kodeBarang = scanner.nextLine();
            barang = cariBarang(kodeBarang);
            if (barang == null) {
                System.out.println("Barang tidak ditemukan.");
            }
        } while (barang == null);

        System.out.print("Masukkan jumlah barang: ");

        int jumlah = scanner.nextInt();
        barang.setQty(jumlah);
        barang.setTotal(jumlah * barang.getHarga());
        daftarBeli.add(barang);

        Scanner scanner2 = new Scanner(System.in);
        System.out.print("Apakah anda ingin menambah barang?(y/n)");
        String nextBarang = scanner2.nextLine();
        if (nextBarang.equalsIgnoreCase("Y")) {
            beliBarang();
        }
    }

    private static double hitungDiskon(double totalPembelian, boolean isMember) {
        double diskon = 0;

        if (totalPembelian >= 100000 && totalPembelian <= 500000) {
            diskon = 0.01;
        } else if (totalPembelian > 500000 && totalPembelian <= 1000000) {
            diskon = 0.025;
        } else if (totalPembelian > 1000000) {
            diskon = 0.05;
        }

        if (isMember) {
            if (totalPembelian >= 100000 && totalPembelian <= 500000) {
                diskon += 0.01;
            } else if (totalPembelian > 500000 && totalPembelian <= 1000000) {
                diskon += 0.015;
            } else if (totalPembelian > 1000000) {
                diskon += 0.02;
            }
        }

        return totalPembelian * diskon;
    }

    private static Barang cariBarang(String kodeBarang) {
        for (Barang barang : daftarBarang) {
            if (barang.getKodeBarang().equals(kodeBarang)) {
                return barang;
            }
        }
        return null;
    }
}
