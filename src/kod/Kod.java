
package kod;

import java.util.Scanner;


public class Kod {

    static Scanner scr=new Scanner(System.in); 
    public static void main(String[] args) {
        int kod=0;
        kod=kod_megadasa(kod);
        Belepes(kod);
        Belepes2(kod);
    }

    private static int kod_megadasa(int kod) {
        do{
            System.out.print("kód megadása: ");
            kod=scr.nextInt();
        }while(!ellenor(kod));
        return kod;
    }

    private static void Belepes(int kod) {
        int x=0;
        boolean elfogad=true;
        do{
            System.out.print("kérem a belépési kódot ("+(x+1)+"/3):");
            int tarto=scr.nextInt();
            if (tarto==kod){
                elfogad=false;
                kod=tarto;
            }
            else{
                x++;
                System.out.println("Hibás pin kód");
            }
        }
        while(x<3 && elfogad);
        if (x<3){
            System.out.println("Belépés engedélyezve");
        }
        else {
            System.out.println("Belépés megtagadva");
        }
    }
    
    private static void Belepes2(int kod){
        String szamok=Integer.toString(kod);
        System.out.println(szamok);
    }

    private static boolean ellenor(int kod) {
        boolean elso=kod>999;
        boolean masodik=kod<1000000;
        boolean kozepe=elso&&masodik;
        return kozepe;
    }
    
}
