/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PraUTS;
/**
 *
 * @author Zenbook
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ParkirApp {
    public static void main(String[] args) throws IOException {

         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalPendapatan = 0;
        boolean ulang = true;

        while (ulang) {

            System.out.println("===== SISTEM PARKIR SEDERHANA =====");

            // Masukkan Jenis Kendaraan
            System.out.print("Jenis kendaraan (motor/mobil/truk/bus): ");
            String jenis = br.readLine().trim().toLowerCase();

            // Pengecekkan Jenis Kendaraan
            if ((((!jenis.equals("motor") && !jenis.equals("mobil")) && !jenis.equals("truk")) && !jenis.equals("bus"))){
                System.out.println("Jenis kendaraan tidak valid!\n");
                continue;
            }

            // Input Berapa Lama Parkir
            System.out.print("Lama parkir (jam): ");
            int jam = Integer.parseInt(br.readLine()); 

            // Input VIP
            System.out.print("Apakah VIP? (y/n): ");
            String vipInput = br.readLine().trim().toLowerCase();
            boolean vip = vipInput.equals("y");

            // Tentukan tarif dasar
            int tarifPerJam;
            
            if (jenis.equals("motor")) {
                tarifPerJam = 2000;
            } else if (jenis.equals("mobil")){
                tarifPerJam = 4000;
            } else if (jenis.equals("truk")) {
                tarifPerJam = 6000;
            }  else if (jenis.equals("bus")) {
                tarifPerJam = 7000;  
            } else {
                tarifPerJam = 0;
            }

            // Gratis 1 jam hanya jika parkir lebih dari 1 jam
            int jamSetelahBonus = jam;

            if (vip && jam > 1) {
                System.out.println("Bonus VIP        : Gratis 1 jam.");
                jamSetelahBonus = jam - 1;
            }


            int total = tarifPerJam * jamSetelahBonus;

            // Diskon jika lebih dari 5 jam
            if (jam > 5) {
            double diskon = total * 0.10;
            total -= diskon;
            System.out.println("Diskon 10% diterapkan.");
            }

            System.out.println("---------------------------");
            System.out.println("Jenis kendaraan  : " + jenis);
            System.out.printf("Lama parkir      : %d jam%n", jamSetelahBonus);
            System.out.println("Tarif per jam    : " + tarifPerJam);
            System.out.printf("Total bayar      : Rp. %d%n", total);
            System.out.println("---------------------------");

            totalPendapatan += total;

            // Tanya mau input lagi
            System.out.print("Input data lagi? (y/n): ");
            String lagi = br.readLine().trim().toLowerCase();
            ulang = lagi.equals("y");

            System.out.println();
        }

        System.out.println("=====================================");
        System.out.println("Total Pendapatan Hari Ini: Rp " + totalPendapatan);
        System.out.println("Program selesai.");
        }
    }

