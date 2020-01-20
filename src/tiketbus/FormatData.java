package tiketbus;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author whiz
 */
public class FormatData {
    
    public boolean kodeBus(String kode){
        if(kode.length() == 5){
            String[] cek = kode.split("-");
            try {
                try{
                    Integer.parseInt(cek[0]);
                    return false;
                } catch (NumberFormatException e){
                    
                }
                Integer.parseInt(cek[1]);
                return true;
             }
             catch (NumberFormatException e)
             {
                return false;
             }
        }
        return false;
    }
    
    public boolean seatBus(String seat){
        try {
            int jmlh = Integer.parseInt(seat);
            return !(jmlh < 1 || jmlh > 999);
        }
        catch (NumberFormatException e)
        {
            return false;
        }
    }
    
    public boolean jam(String jam){
     if(jam.length() == 5){
            String[] cek = jam.split(":");
            try {
                int jm = Integer.parseInt(cek[0]);
                int menit = Integer.parseInt(cek[1]);
                
                return !( jm < 0 || jm > 23 || menit < 0 || menit > 59);
             }
             catch (NumberFormatException e)
             {
                return false;
             }
        }
        return false;
    }
    
    public String formatJmlhSeat(String seat){
        int l = seat.length();
        if(l == 1){
            return " "+seat+" ";
        } else if(l == 2){
            return " "+seat;
        } else {
            return seat;
        }
    }
    
    public String formatJam(String jam){
        String [] j = jam.split(":");
        return j[0]+":"+j[1];
    }
}
