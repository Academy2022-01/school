package it.unikey;

import java.util.Comparator;

public class CartaComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        int v1 = getValue(s1);
        int v2 = getValue(s2);
        if( v1==v2 ) return 0;
        else if( v1>v2 ) return 1;
        else return -1;
    }

    private static int getValue(String s){
        StringBuilder s1Sub = new StringBuilder(s.substring(0, 2));
        int v1;
        if(Character.isDigit(s1Sub.charAt(0))) {
            v1 = Integer.parseInt(s1Sub.toString());
        } else {
            switch (s1Sub.charAt(0)){
                case 'A': v1=14; break;
                case 'K': v1=13; break;
                case 'Q': v1=12; break;
                case 'J': v1=11; break;
                default : throw new RuntimeException("Carta non valida");
            }
        }
        return v1;
    }

}
