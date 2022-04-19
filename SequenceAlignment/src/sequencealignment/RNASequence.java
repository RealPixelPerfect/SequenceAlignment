package sequencealignment;

public class RNASequence extends Sequence {

    public RNASequence(String sequenceString) {
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
        return "";
    }
}
