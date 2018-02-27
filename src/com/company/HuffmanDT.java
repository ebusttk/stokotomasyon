package com.company;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HuffmanDT {
    static int IdCounter = 0;                               // used to number each node with unique Id

    static class dugum implements Comparable {
        public char harf;                             // the letter from the string, or '#' if inner node
        public int Id;                                  // unique Id (used to generate DOT graph)
        public int frekans;                                // counts number of occurrences
        public dugum sol;                               // pointer to left child, if any
        public dugum sag;                              // pointer to sag child, if nay

        dugum( char a, int f, dugum lft, dugum rt ) {
            Id = IdCounter++;
            harf = a; frekans = f; sol = lft; sag = rt;
        }

        public boolean yaprak_mi() { return sol==null && sag==null; }
        @Override
        public int compareTo(Object o) {
            return frekans - ((dugum) o).frekans;
        }
    }
    public static String getharfler() {
        Scanner a=new Scanner(System.in);
        String s=a.nextLine();
        return  s;
    }

    private static HashMap<Character, Integer> getharf_frekans ( String s ) {
        HashMap<Character, Integer> frekans = new HashMap<Character, Integer>();
        for ( int i=0; i< s.length(); i++ ) {
            char c = s.charAt(i);
            if ( frekans.containsKey( c ) )
                frekans.put( c, frekans.get( c )+1 );
            else
                frekans.put( c,  1 );
        }
        return frekans;
    }

    private static dugum agac( HashMap<Character, Integer> freqs ) {
        PriorityQueue<dugum> prioQ = new PriorityQueue<dugum>();
        for ( char c: freqs.keySet() )
            prioQ.add( new dugum( c, freqs.get(c), null, null ) );

        while ( prioQ.size() > 1 ) {
            dugum sol = prioQ.poll();
            dugum sag = prioQ.poll();
            prioQ.add( new dugum( '#', sol.frekans + sag.frekans, sol, sag ) );
        }

        return prioQ.poll();
    }

    /*private static void DotDFS( dugum dugum ) {
        if ( dugum.yaprak_mi() ) {
            System.out.println(  String.format( "%d [label=\"%s (%d)\"];",
                    dugum.Id, dugum.harf, dugum.frekans) );
            return;
        }
        if ( dugum.sol != null ) {
            System.out.println(  String.format( "%d [label=\"%s (%d)\"];",
                    dugum.Id, dugum.harf, dugum.frekans) );
            System.out.println( String.format( "%d -> %d [label=\"0\"];",
                    dugum.Id, dugum.sol.Id ) );
            DotDFS( dugum.sol );
        }
        if ( dugum.sag != null ) {
            System.out.println(  String.format( "%s [label=\"%s (%d)\"];",
                    dugum.Id, dugum.harf, dugum.frekans) );
            System.out.println( String.format( "%s -> %s [label=\"1\"];",
                    dugum.Id, dugum.sag.Id ) );
            DotDFS( dugum.sag );
        }
    }*/
    private static HashMap<Character, String> getEncoding(dugum root) {
        HashMap<Character, String> encoding = new HashMap<Character, String>();
        DFS( root, "", encoding );
        return encoding;
    }

    private static void DFS(dugum dugum, String code, HashMap<Character, String> encoding) {
        if ( dugum.yaprak_mi() )
            encoding.put( dugum.harf, code );
        else {
            if ( dugum.sol != null )
                DFS( dugum.sol, code+"0", encoding );
            if ( dugum.sag != null )
                DFS( dugum.sag, code+"1", encoding );
        }
    }


    public static void main(String[] args) {

        // create a synthetic string with know distribution of chars
        String s = getharfler();

        HashMap<Character, Integer> freqs = getharf_frekans( s );
        dugum root = agac( freqs );

        //generateHuffmanTreeDOT( root );

        HashMap<Character, String> encoding = getEncoding( root );
        System.out.println( encoding );

        int encodedStringLength = 0;
        int sumFreqs = 0;
        for ( char c: encoding.keySet() ) {
            int frekans = freqs.get( c );
            sumFreqs += frekans;
            String code = encoding.get( c );
            encodedStringLength += frekans * code.length();
        }
        System.out.println( "Giriş yaptığınız "+s+" verisi\nASCII kodu ile kodlanırsa,her karakter için 1 byte(8 bit)’lık alan "+
                "gerektiğinden toplamda " + sumFreqs * 8 + " bit e  ihtiyaç olacaktı." );
        System.out.println( "Aynı veri Huffman kodlaması ile " + encodedStringLength + " bittir." );

    }



}