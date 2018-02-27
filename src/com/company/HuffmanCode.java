package com.company;

import java.util.*;

abstract class HuffmanTree implements Comparable<HuffmanTree> {
    public final int frekans;
    public HuffmanTree(int freq) { frekans = freq; }

    public int compareTo(HuffmanTree tree) {
        return frekans - tree.frekans;
    }
}

class HuffmanLeaf extends HuffmanTree {
    public final char value;

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        value = val;
    }
}

class HuffmanNode extends HuffmanTree {

    public final HuffmanTree left, right;

    public HuffmanNode(HuffmanTree l, HuffmanTree r) {
        super(l.frekans + r.frekans);
        left = l;
        right = r;
    }
}

public class HuffmanCode {

    public static HuffmanTree buildTree(int[] charFreqs) {
        PriorityQueue<HuffmanTree> trees = new PriorityQueue<HuffmanTree>();

        for (int i = 0; i < charFreqs.length; i++)
            if (charFreqs[i] > 0)
                trees.offer(new HuffmanLeaf(charFreqs[i], (char)i));

        assert trees.size() > 0;

        while (trees.size() > 1) {

            HuffmanTree a = trees.poll();
            HuffmanTree b = trees.poll();

            trees.offer(new HuffmanNode(a, b));
        }
        return trees.poll();
    }

    public static void printCodes(HuffmanTree tree, StringBuffer code) {
        assert tree != null;

        if (tree instanceof HuffmanLeaf) {
            HuffmanLeaf leaf = (HuffmanLeaf)tree;

            System.out.println(leaf.value + "\t\t" + leaf.frekans + "\t\t" + code);

        } else if (tree instanceof HuffmanNode) {
            HuffmanNode node = (HuffmanNode)tree;

            code.append('0');
            printCodes(node.left, code);
            code.deleteCharAt(code.length()-1);

            code.append('1');
            printCodes(node.right, code);
            code.deleteCharAt(code.length()-1);
        }


    }

    public static void main(String[] args) {
        int sumfreq=0;
        Scanner a=new Scanner(System.in);
        String test=a.nextLine();

        int[] charFreqs = new int[256];

        for (char c : test.toCharArray()){
            charFreqs[c]++;

            }

        HuffmanTree tree = buildTree(charFreqs);
        sumfreq=test.length();


        System.out.println("HARF\tFREKANS\tHUFFMAN KODU");
        printCodes(tree, new StringBuffer());

        System.out.println(test+" girdisi\n ASCII kodu ile kodlanırsa "+sumfreq*8+" bit yer kaplar");

    }
}