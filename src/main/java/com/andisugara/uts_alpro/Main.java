/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.andisugara.uts_alpro;

import com.andisugara.uts_alpro.soal_2.Soal2;
import com.andisugara.uts_alpro.soal_1.CekSegitigaForm;
import java.util.Scanner;

/**
 *
 * @author andi
 */
public class Main {

    public static void main(String[] args) throws Exception {
        String header = "UJIAN AKHIR SEMESTER\n" + "Nama\t\t: Andi Sugara Putra\n"
                + "NIM\t\t: 22552011093\n"
                + "Kelas\t\t: Tif RM 22 B - OFFLINE\n"
                + "Mata Kuliah\t: Algoritma dan Pemograman II\n"
                + "Dosen\t\t: Bayu Rimba Pratama, S.T., M.Kom. \n"
                + "============================================\n";

        String textSoal = "1.Menentukan Jenis Segitiga menggunakan Java GUI\n"
                + "2.Pos Sederhana\n";

        System.out.println(header);
        System.out.println(textSoal);
        Scanner pilihanSoal = new Scanner(System.in);
        System.out.print("Masukkan Nomor Soal yang akan dijalankan: ");
        int nomorSoal = pilihanSoal.nextInt();
        switch (nomorSoal) {
            case 1:
                CekSegitigaForm.main();
                break;
            case 2:
                Soal2.main();
                break;
            default:
                System.out.println("Nomor Soal yang anda masukkan tidak ada");
        }

    }
}
