package sequencealignment;

public class DNASequence extends NucleotideSequence {

    public DNASequence(String sequenceString) {
        super(sequenceString);
    }

    String flip(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";
        
        for (int i = 0; i < sequenceString.length(); i++) {
            if (initialCharArray[i] == Parser.DNA_C) {
                output += 'G';
            }else if (initialCharArray[i] == Parser.DNA_G) {
                output += 'C';
            }else if (initialCharArray[i] == Parser.DNA_A) {
                    output += 'T';
            }else if (initialCharArray[i] == Parser.DNA_T) {
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
                if(initialCharArray[i] < Parser.DNA_LETTERS.length()){
                    output += Parser.DNA_LETTERS.charAt((int) initialCharArray[i]);
                }
                
            }
        }

        return output;

    }
    
    String toRNA(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";

        for (int i = 0; i < sequenceString.length(); i++) {
            if (initialCharArray[i] == Parser.DNA_T) {
                output += 'U';
            } else {
                if(initialCharArray[i] < Parser.DNA_LETTERS.length()){
                    output += Parser.DNA_LETTERS.charAt((int) initialCharArray[i]);
                }
            }
        }
        return output;
    }
    
    String toProtein(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";
                
        for (int i = 2; i < sequenceString.length(); i+=3) {
            output += Parser.PROTEIN_LETTERS.charAt(Parser.GENETIC_CODE[(int)initialCharArray[i-2]][(int)initialCharArray[i-1]][(int)initialCharArray[i-0]]); 
        }
                
        return output;
    }
       
}

//attttttttttttttttttttttatatattattaactcatcatcactctactatcactaccccatattatatt
