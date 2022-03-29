package sequencealignment;

public class ProteinSequence extends Sequence {
    public ProteinSequence(String sequenceString){
        super(sequenceString);
    }
    
    @Override
    String toReadable(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";

        for (int i = 0; i < sequenceString.length(); i++) {
             if(initialCharArray[i] == Parser.DASH){
                output += '-';
            } else {
                output += (char)Parser.PROTEIN_LETTERS.indexOf(initialCharArray[i]);
            }    
        }
        return output;
    }
    
    
    
    
    
}
