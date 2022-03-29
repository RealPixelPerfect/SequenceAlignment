package sequencealignment;

public class Parser {

    static final int DASH=Character.MAX_VALUE;
    
    static final int RNA_A=0;
    static final int RNA_U=1;
    static final int RNA_C=2;
    static final int RNA_G=3;
    
    static final int DNA_A=0;
    static final int DNA_T=1;
    static final int DNA_C=2;
    static final int DNA_G=3;
    
    static final int PROTEIN_A=0;
    static final int PROTEIN_R=1;
    static final int PROTEIN_N=2;
    static final int PROTEIN_D=3;
    static final int PROTEIN_C=4;
    static final int PROTEIN_Q=5;
    static final int PROTEIN_E=6;
    static final int PROTEIN_G=7;
    static final int PROTEIN_H=8;
    static final int PROTEIN_I=9;
    static final int PROTEIN_L=10;
    static final int PROTEIN_K=11;
    static final int PROTEIN_M=12;
    static final int PROTEIN_F=13;
    static final int PROTEIN_P=14;
    static final int PROTEIN_S=15;
    static final int PROTEIN_T=16;
    static final int PROTEIN_W=17;
    static final int PROTEIN_Y=18;
    static final int PROTEIN_V=19;
    
    char[] charArray;
    
    Parser(String inputString){
        charArray = inputString.toCharArray();
    }
    
    
    
    public RNASequence parseRNA(){
        char[] modifiedCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            switch(charArray[i]){
                case 'A':
                    modifiedCharArray[i] = RNA_A;
                    break;
                case 'U':
                    modifiedCharArray[i] = RNA_U;
                    break;
                case 'C':
                    modifiedCharArray[i] = RNA_C;
                    break;
                case 'G':
                    modifiedCharArray[i] = RNA_G;
                    break;
                case '-':
                    modifiedCharArray[i] = DASH;
                    break;
            }
        }
        String outString = new String(modifiedCharArray);
        return new RNASequence(outString);
    }
    
    public DNASequence parseDNA(){
        char[] modifiedCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            switch(charArray[i]){
                case 'A':
                    modifiedCharArray[i] = DNA_A;
                    break;
                case 'T':
                    modifiedCharArray[i] = DNA_T;
                    break;
                case 'C':
                    modifiedCharArray[i] = DNA_C;
                    break;
                case 'G':
                    modifiedCharArray[i] = DNA_G;
                    break;
                case '-':
                    modifiedCharArray[i] = DASH;
                    break;
            }
        }
        String outString = new String(modifiedCharArray);
        return new DNASequence(outString);

    }
       
    public ProteinSequence parseProtein(){
        char[] modifiedCharArray = new char[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            switch(charArray[i]){
                case 'A':
                    modifiedCharArray[i] = PROTEIN_A;
                    break;
                case 'R':
                    modifiedCharArray[i] = PROTEIN_R;
                    break;
                case 'N':
                    modifiedCharArray[i] = PROTEIN_N;
                    break;
                case 'D':
                    modifiedCharArray[i] = PROTEIN_D;
                    break;
                case 'C':
                    modifiedCharArray[i] = PROTEIN_C;
                    break;
                case 'Q':
                    modifiedCharArray[i] = PROTEIN_Q;
                    break;
                case 'E':
                    modifiedCharArray[i] = PROTEIN_E;
                    break;
                case 'G':
                    modifiedCharArray[i] = PROTEIN_G;
                    break;
                case 'H':
                    modifiedCharArray[i] = PROTEIN_H;
                    break;
                case 'I':
                    modifiedCharArray[i] = PROTEIN_I;
                    break;
                case 'L':
                    modifiedCharArray[i] = PROTEIN_L;
                    break;
                case 'K':
                    modifiedCharArray[i] = PROTEIN_K;
                    break;
                case 'M':
                    modifiedCharArray[i] = PROTEIN_M;
                    break;
                case 'F':
                    modifiedCharArray[i] = PROTEIN_F;
                    break;
                case 'P':
                    modifiedCharArray[i] = PROTEIN_P;
                    break;
                case 'S':
                    modifiedCharArray[i] = PROTEIN_S;
                    break;
                case 'T':
                    modifiedCharArray[i] = PROTEIN_T;
                    break;
                case 'W':
                    modifiedCharArray[i] = PROTEIN_W;
                    break;
                case 'Y':
                    modifiedCharArray[i] = PROTEIN_Y;
                    break;
                case 'V':
                    modifiedCharArray[i] = PROTEIN_V;
                    break;
                case '-':
                    modifiedCharArray[i] = DASH;
                    break;
            }
        }
        String outString = new String(modifiedCharArray);
        return new ProteinSequence(outString);
    }
      
}
