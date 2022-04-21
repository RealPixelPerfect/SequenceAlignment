package sequencealignment;

public class RNASequence extends Sequence {

    public RNASequence(String sequenceString) {
        super(sequenceString);
    }

    String flip(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";
        
        for (int i = 0; i < sequenceString.length(); i++) {
            if (initialCharArray[i] == Parser.RNA_C) {
                output += 'G';
            }else if (initialCharArray[i] == Parser.RNA_G) {
                output += 'C';
            }else if (initialCharArray[i] == Parser.RNA_A) {
                    output += 'U';
            }else if (initialCharArray[i] == Parser.RNA_U) {
                output += 'A';
            }
        }

        return output;
    };
    
    @Override
    String toReadable() {
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";

        for (int i = 0; i < sequenceString.length(); i++) {
            if (initialCharArray[i] == Parser.DASH) {
                output += '-';
            } else {
                if(initialCharArray[i] < Parser.RNA_LETTERS.length()){
                    output += Parser.RNA_LETTERS.charAt((int) initialCharArray[i]);
                }
            }
        }

        return output;

    }
        
    String toDNA(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";

        for (int i = 0; i < sequenceString.length(); i++) {
            if (initialCharArray[i] == Parser.RNA_U) {
                output += 'T';
            } else {
                if(initialCharArray[i] < Parser.RNA_LETTERS.length()){
                    output += Parser.RNA_LETTERS.charAt((int) initialCharArray[i]);
                }
            }
        }
        return output;
    }
    
    String toProtein(){
        this.flip();
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";
        
        
        for (int i = 2; i < sequenceString.length(); i+=3) {
            output += Parser.PROTEIN_LETTERS.charAt(Parser.GENETIC_CODE[(int)initialCharArray[i-2]][(int)initialCharArray[i-1]][(int)initialCharArray[i-0]]); 
        }
                
        return output;
    }
}
