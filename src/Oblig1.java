
////// Løsningsforslag Oblig 1 ////////////////////////

import java.lang.UnsupportedOperationException;
import java.util.Arrays;
import java.util.NoSuchElementException;

//s326156 Alexandros Messaritakis Chousein Aga

public class Oblig1 {


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
        try {
            char sisteElement = a[a.length - 1];

            for (int i = a.length - 2; i >= 0; --i) {
                char temp = a[i];
                a[i + 1] = temp;

            }

            a[0] = sisteElement;
        }catch (Exception e){
            System.err.println("OBS: Tomt array i oppgave 5");
        }
    }

    ///// Oppgave 7 //////////////////////////////////////
    /// 7a)
    public static String flett(String s, String t) {
        int remain;
        StringBuilder str = new StringBuilder();
        if(s.length() < t.length()){
            remain= s.length();

        }else{
            remain = t.length();
        }
        for (int i = 0; i < remain; i++)
        {
            str.append(s.charAt(i)).append(t.charAt(i)); //tar første med den andre første
        }

        for (int i = remain; i < s.length(); i++)
        {
            str.append(s.charAt(i));  // tar med resten bakerst
        }
        for (int i = remain; i < t.length(); i++)
        {
            str.append(t.charAt(i));  // tar med resten
        }
        return str.toString();

    }

    /// 7b)
    public static String flett(String... s) {
        StringBuilder str = new StringBuilder();
        if (s.length==0) str.append("");
        int y  = s.length;



        for (int i = 1; i < s.length; i++)
        {
            int temp = s[i].length();
           // System.out.println(s[i].length()+""+s[i]);
            if (temp > y) y = temp;

        }

        for (int i=0; i<y; i++)
        {
            for (String t:s)
            {
                if (i<t.length())
                {
                    str.append(t.charAt(i));
                }
            }
        }
        return str.toString();
    }



}  // Oblig1
