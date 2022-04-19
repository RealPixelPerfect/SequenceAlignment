package sequencealignment;

public class DNASequence extends NucleotideSequence {

    public DNASequence(String sequenceString) {
        super(sequenceString);
    }

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
        return "";
    }
    
   
}

//attttttttttttttttttttttatatattattaactcatcatcactctactatcactaccccatattatatt
