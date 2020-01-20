/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiketbus;
import java.io.IOException;
/**
 *
 * @author whiz
 */
public class Views {
    
    public void header(){
        System.out.println("--------------------------------------------------------");
        System.out.println("*    ____________ __ ____________   ____  __  _______  *");
        System.out.println("*   /_  __/  _/ //_// ____/_  __/  / __ )/ / / / ___/  *");
        System.out.println("*    / /  / // ,<  / __/   / /    / __  / / / /\\__ \\   *");
        System.out.println("*   / / _/ // /| |/ /___  / /    / /_/ / /_/ /___/ /   *");
        System.out.println("*  /_/ /___/_/ |_/_____/ /_/    /_____/\\____//____/    *");
        System.out.println("* \t\t\t\t\t\t       *");
        System.out.println("*      ____  ___    _   ______  __  ___   ________     *");
        System.out.println("*     / __ )/   |  / | / / __ \\/ / / / | / / ____/     *");
        System.out.println("*    / __  / /| | /  |/ / / / / / / /  |/ / / __       *");
        System.out.println("*   / /_/ / ___ |/ /|  / /_/ / /_/ / /|  / /_/ /       *");
        System.out.println("*  /_____/_/  |_/_/ |_/_____/\\____/_/ |_/\\____/        *");
        System.out.println("* \t\t\t\t\t\t       *");
        System.out.println("*****************| PBO-8 2020 UNIKOM |******************");
        System.out.println("********| 10118325-10118342-10118312-10118321 |*********");
    }
    
    public void menu(){
        System.out.println("------------------------| MENU |------------------------");
        System.out.println(" 1. Data Bus");
        System.out.println(" 2. Data Perjalanan");
        System.out.println(" 3. Data Pembeli");
        System.out.println(" 0. Keluar");
        System.out.println("--------------------------------------------------------");
    }
    
    public void pilihan(){
        System.out.print("Pilihan Anda : ");
    }
    
    public void menuBus(){
        System.out.println("----------------------| MENU BUS |----------------------");
        System.out.println(" 1. Tambah Data Bus");
        System.out.println(" 2. Tampilkan Data Bus");
        System.out.println(" 3. Ubah Data Bus");
        System.out.println(" 4. Cari Data Bus");
        System.out.println(" 5. Hapus Data Bus");
        System.out.println(" 0. Kembali");
        System.out.println("--------------------------------------------------------");
    }
    
    public void menuDestination(){
        System.out.println("-------------------| MENU PERJALANAN |------------------");
        System.out.println(" 1. Tambah Perjalanan");
        System.out.println(" 2. Tampilkan Perjalanan");
        System.out.println(" 3. Ubah Perjalanan");
        System.out.println(" 4. Cari Perjalanan");
        System.out.println(" 5. Hapus Perjalanan");
        System.out.println(" 0. Kembali");
        System.out.println("--------------------------------------------------------");
    }
    
    public void menuBooking(){
        System.out.println("-------------------| MENU PEMESANAN |-------------------");
        System.out.println(" 1. Tambah Pemesanan");
        System.out.println(" 2. Tampilkan Pemesanan");
        System.out.println(" 3. Ubah Pemesanan");
        System.out.println(" 4. Cari Pemesanan");
        System.out.println(" 5. Hapus Pemesanan");
        System.out.println(" 0. Kembali");
        System.out.println("--------------------------------------------------------");
    }
    
    public void searchBus(){
        System.out.println("--------------------| PENCARIAN BUS |-------------------");
        System.out.println(" 1. Cari Berdasarkan Kode Bus");
        System.out.println(" 2. Cari Berdasarkan Jumlah Seat");
        System.out.println(" 3. Cari Berdasarkan Jam Berangkat");
        System.out.println(" 0. Kembali");
        System.out.println("--------------------------------------------------------");
    }   
    
    public void clrscr(){
    //Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    
    public void bye(){
        System.out.println("Bye..");
    }
    
}
