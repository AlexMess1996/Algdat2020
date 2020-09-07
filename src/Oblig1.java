
////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;


public class Oblig1 {

    public static void main(String[]args)
    {
        //int [] a = {16,4,6,8,15,6,1,3};
        //int [] a = {3,3,4,5,5,6,7,7};
       // int [] a = {5,3,7,4,3,5,7,8,6,7};
        char [] a = {'A','B','C','D','E','F','G','H','I','J'};


      //  System.out.println(maks(a));
      //  System.out.println(ombyttinger(a));
       // System.out.println(antallUlikeSortert(a));
        //System.out.println(antallUlikeUsortert(a));
      //  delsortering(a);
      //  System.out.println(Arrays.toString(a));
        rotasjon(a);
        System.out.println(a);

    }
    private Oblig1() {}

    ///// Oppgave 1 //////////////////////////////////////
    public static int maks(int[] a) {
        if (a.length == 0) {
            System.err.println("OBS: Tomt array i oppgave 1");
            throw new NoSuchElementException();
        }

        for(int i = 1; i<a.length; ++i)
        {
            if(a[i]<a[i-1]){ //6*Hn
                int stor,liten;
                stor = a[i-1];
                liten = a[i];

                a[i-1] = liten;
                a[i] = stor;

            }

        }

        return a[a.length-1];
    }

    public static int ombyttinger(int[] a) {
        int ombyttinger=0;

        for(int i = 1; i<a.length;++i){
            if(a[i]<a[i-1]){ //6*Hn
                int stor,liten;
                stor = a[i-1];
                liten = a[i];

                a[i-1] = liten;
                a[i] = stor;
                ombyttinger++;

            }

        }

        return ombyttinger;
    }

    ///// Oppgave 2 //////////////////////////////////////
    public static int antallUlikeSortert(int[] a) {
        int teller = 1;
        if(a.length == 0){
            teller = 0;
        }
        for(int i = 1; i<a.length; ++i){
            if (a[i - 1] > a[i]) {
                System.err.println("OBS: Usorert tabell i oppgave 2");
                throw new IllegalStateException();
            }
            if(a[i-1]<a[i]){
                teller++;
            }

        }
        return teller;
    }

    ///// Oppgave 3 //////////////////////////////////////
    public static int antallUlikeUsortert(int[] a) {
        int teller = 1;
        if (a.length == 0){
            teller = 0;
        }



        for(int i = 1; i<a.length; ++i){
            int compareValue = a[i];
            boolean duplicatedValue = false;


            for(int k = i-1; k>=0; --k){
                if(compareValue == a[k]){
                    duplicatedValue = true;

                }
            }

            if(!duplicatedValue){

                teller++;
            }
        }

        return teller;
    }

    ///// Oppgave 4 //////////////////////////////////////
    public static void delsortering(int[] a) {
        int oddetallsTeller = 0;

        //teller antall oddetall
        for (int k = 0; k < a.length; k++) {
            if (!erPartall(a[k])) {
                oddetallsTeller++;
            }
        }

        int partallsIndeks = oddetallsTeller;
        //sorterer oddetall og partall fra hverandre
        for (int f = 0; f < oddetallsTeller; ) {
            if (erPartall(a[f]) && !erPartall(a[partallsIndeks])) {
                int temp = a[f];
                a[f]=a[partallsIndeks];
                a[partallsIndeks] = temp;
                f++;
            } else if (erPartall(a[f]) && erPartall(a[partallsIndeks])) {
                partallsIndeks++;
            } else if (!erPartall(a[f])) {
                f++;
            }
        }

        Arrays.sort(a,0,oddetallsTeller);
        Arrays.sort(a,oddetallsTeller,a.length);

    }
    public static boolean erPartall(int a) {
        boolean partall = true;

        if (a % 2 == 1 || a % 2 == -1) {
            partall = false;
        }

        return partall;
    }
    ///// Oppgave 5 //////////////////////////////////////
    public static void rotasjon(char[] a) {
       // System.out.println(a.length);
        char sisteElement = a[a.length-1];

        for(int i =a.length-2; i>=0;--i){
            char temp = a[i];
            a[i+1] = temp;

        }

        a[0] = sisteElement;
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        throw new UnsupportedOperationException();
    }

    /// 7b)
    public static String flett(String... s) {
        throw new UnsupportedOperationException();
    }



}  // Oblig1
