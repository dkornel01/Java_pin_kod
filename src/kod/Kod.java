
package kod;

import java.util.Random;
import java.util.Scanner;


public class Kod {

    static Scanner scr=new Scanner(System.in); 
    static Random rnd=new Random();
    public static void main(String[] args) {
        pin_kod();
    }

    private static void pin_kod() {
        int kod=0;
        kod=kod_megadasa(kod);
        //Belepes(kod);
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
        String[] lista=new String[10];
        for (int i=0;i<10;i++){
            lista[i]=Integer.toString(i);
        }
        String szamok=Integer.toString(kod);
        int i=0;
        int k=0;
        while (i<szamok.length()&&k<3){
            char [] valaszto=new char[3];
            int x=0;
            for (;x<3;x++){
                valaszto[x]=veletlen_szamok(lista, valaszto, x, szamok, i);
            }
            valaszto[rnd.nextInt(3)]=szamok.charAt(i);
            boolean helyes=valasztas(valaszto,szamok,i);
            if (helyes){
                i++;
            }
            else{
                k++;
            }
        }
        
    }

    private static char veletlen_szamok(String[] lista, char[] valaszto, int x, String szamok, int i) {
        do{
            int szam=rnd.nextInt(10);
            String egy=lista[szam];
            valaszto[x]=egy.charAt(0);
        }while(valaszto[x]==szamok.charAt(i));
        return valaszto[x];
    }

    private static boolean ellenor(int kod) {
        boolean elso=kod>999;
        boolean masodik=kod<1000000;
        boolean kozepe=elso&&masodik;
        return kozepe;
    }

    private static boolean valasztas(char[] valaszto, String szamok, int i) {
        boolean talalt=false;
        for (int y=0;y<3;y++){
            System.out.println(valaszto[y]);
        }
        
        int sor=-1;
        sor = sor_valasztas(sor);
        System.out.println("");
        if (valaszto[sor-1]==szamok.charAt(i)){
            System.out.println("helyes");
            talalt=true;
        }
        else {
            System.out.println("helytelen");
        }
        return talalt;
    }

    private static int sor_valasztas(int sor) {
        do{
            System.out.print("irja be egytol haromig melyik szam jo: ");
            sor=scr.nextInt();
        }while (sor<0||sor>3);
        return sor;
    }
}
