package sequencealignment;

public class Parser {

    static final int DASH = Character.MAX_VALUE;

    static final int RNA_A = 0;
    static final int RNA_U = 1;
    static final int RNA_C = 2;
    static final int RNA_G = 3;

    static final int DNA_A = 0;
    static final int DNA_T = 1;
    static final int DNA_C = 2;
    static final int DNA_G = 3;

    static final int PROTEIN_A = 0;
    static final int PROTEIN_R = 1;
    static final int PROTEIN_N = 2;
    static final int PROTEIN_D = 3;
    static final int PROTEIN_C = 4;
    static final int PROTEIN_Q = 5;
    static final int PROTEIN_E = 6;
    static final int PROTEIN_G = 7;
    static final int PROTEIN_H = 8;
    static final int PROTEIN_I = 9;
    static final int PROTEIN_L = 10;
    static final int PROTEIN_K = 11;
    static final int PROTEIN_M = 12;
    static final int PROTEIN_F = 13;
    static final int PROTEIN_P = 14;
    static final int PROTEIN_S = 15;
    static final int PROTEIN_T = 16;
    static final int PROTEIN_W = 17;
    static final int PROTEIN_Y = 18;
    static final int PROTEIN_V = 19;
    static final int STOP = 20;
    
    static final String DNA_LETTERS = "ATCG";
    static final String RNA_LETTERS = "AUCG";
    static final String PROTEIN_LETTERS = "ARNDCQEGHILKMFPSTWYV*";

    static final int[][][] GENETIC_CODE = 
    {
        {{PROTEIN_K, PROTEIN_N, PROTEIN_N, PROTEIN_K}, //AAA, AAT, AAC, AAG
         {PROTEIN_I, PROTEIN_I, PROTEIN_I, PROTEIN_M}, //ATA, ATT, ATC, ATG
         {PROTEIN_T, PROTEIN_T, PROTEIN_T, PROTEIN_T}, //ACA, ACT, ACC, ACG
         {PROTEIN_R, PROTEIN_S, PROTEIN_S, PROTEIN_R}},//AGA, AGT, AGC, AGG
        
        {{STOP     , PROTEIN_Y, PROTEIN_Y, STOP     }, //TAA, TAT, TAC, TAG
         {PROTEIN_L, PROTEIN_F, PROTEIN_F, PROTEIN_L}, //TTA, TTT, TTC, TTG
         {PROTEIN_S, PROTEIN_S, PROTEIN_S, PROTEIN_S}, //TCA, TCT, TGC, TCG
         {STOP     , PROTEIN_C, PROTEIN_C, PROTEIN_W}},//TGA, TGT, TGC, TGG
        
        {{PROTEIN_Q, PROTEIN_H, PROTEIN_H, PROTEIN_Q}, //CAA, CAT, CAC, CAG
         {PROTEIN_L, PROTEIN_L, PROTEIN_L, PROTEIN_L}, //CTA, CTT, CTC, CTG
         {PROTEIN_P, PROTEIN_P, PROTEIN_P, PROTEIN_P}, //CCA, CCT, CCC, CCG
         {PROTEIN_R, PROTEIN_R, PROTEIN_R, PROTEIN_R}},//CGA, CGT, CGC, CGG
        
        {{PROTEIN_E, PROTEIN_D, PROTEIN_D, PROTEIN_E}, //GAA, GAT, GAC, GAG
         {PROTEIN_V, PROTEIN_V, PROTEIN_V, PROTEIN_V}, //GTA, GTT, GTC, GTG
         {PROTEIN_A, PROTEIN_A, PROTEIN_A, PROTEIN_A}, //GCA, GCT, GCC, GCG
         {PROTEIN_G, PROTEIN_G, PROTEIN_G, PROTEIN_G}} //GGA, GGT, GGC, GGG
    };
    
    char[] charArray;

    Parser(String inputString) {
        charArray = inputString.toCharArray();
        
    }

    public RNASequence parseRNA() {
        String outString = "";
        for (int i = 0; i < charArray.length; i++) {
            int index = RNA_LETTERS.indexOf(charArray[i]);
            if(index != -1){
                outString += (char) index;
            }
        }
        return new RNASequence(outString);
    }

    public DNASequence parseDNA() {
        String outString = "";
        for (int i = 0; i < charArray.length; i++) {
            int index = DNA_LETTERS.indexOf(charArray[i]);
            if(index != -1){
                outString += (char) index;
            }
        }
        return new DNASequence(outString);

    }

    public ProteinSequence parseProtein() {
        String outString = "";
        for (int i = 0; i < charArray.length; i++) {
            int index = PROTEIN_LETTERS.indexOf(charArray[i]);
            if(index != -1){
                outString += (char) index;
            }
        }
        return new ProteinSequence(outString);
    }
}
