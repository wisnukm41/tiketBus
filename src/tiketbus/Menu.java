/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketbus;

import java.util.Scanner;

/**
 *
 * @author whiz
 */
public class Menu {
        Views display = new Views();
        Scanner sc = new Scanner(System.in);
        
      public String bus(){
        BusHandle bus = new BusHandle();
        String pil;
        
        do{ 
            display.clrscr();
            display.header();
            display.menuBus();
            display.pilihan();

            pil = sc.nextLine();

            switch (pil) {
                case "1":
                    bus.add();                 
                    break;
                case "2":
                    bus.view();
                    sc.nextLine();
                    break;
                case "3":
                    bus.update();
                    break;
                case "4":
                    bus.search();
                    break;
                case "5":
                    bus.delete();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Pilihan tidak Sesuai!");
                    sc.nextLine();
                    break;
            }
        } while (!pil.equals("0"));
        
        return "-1";
    }
      
    public String destination(){
        
        String pil;
        
        do{ 
            display.clrscr();
            display.header();
            display.menuDestination();
            display.pilihan();

            pil = sc.nextLine();

            switch (pil) {
                case "1":
                    System.out.println("Tambah Perjalanan");
                    sc.nextLine();                   
                    break;
                case "2":
                    System.out.println("Tampil Perjalanan");
                    sc.nextLine();
                    break;
                case "3":
                    System.out.println("Ubah Perjalanan");
                    sc.nextLine();
                    break;
                case "4":
                    System.out.println("Cari Perjalanan");
                    sc.nextLine();
                    break;
                case "5":
                    System.out.println("Hapus Perjalanan");
                    sc.nextLine();
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Pilihan tidak Sesuai!");
                    sc.nextLine();
                    break;
            }
        } while (!pil.equals("0"));
        
        return "-1";
    }
}
