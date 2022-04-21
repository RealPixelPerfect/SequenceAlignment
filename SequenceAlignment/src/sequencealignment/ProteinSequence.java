package sequencealignment;

public class ProteinSequence extends Sequence {

    public ProteinSequence(String sequenceString) {
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
                if(initialCharArray[i] < Parser.PROTEIN_LETTERS.length()){
                    output += Parser.PROTEIN_LETTERS.charAt((int) initialCharArray[i]);
                }
            }
        }
        return output;
    } 
}
