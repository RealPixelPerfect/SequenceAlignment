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
                output += "--";
            } else {
                output += Parser.DNA_LETTERS.charAt(initialCharArray[i]);
            }
        }

        return output;

    }
}
