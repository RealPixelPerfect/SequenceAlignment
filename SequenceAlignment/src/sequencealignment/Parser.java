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

    static final String DNA_LETTERS = "ATCG";
    static final String RNA_LETTERS = "AUCG";
    static final String PROTEIN_LETTERS = "ARNDCQEGHILKMFPSTWYV";

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
