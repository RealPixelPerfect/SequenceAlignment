/*
 * 
 * Free to share, use and modify.
 * 
 */
package sequencealignment;

/**
 *
 * @author love
 */
public class ProteinSequence extends Sequence {
    public ProteinSequence(String sequenceString){
        super(sequenceString);
    }
    
    @Override
    String toReadable(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";
        
        String[] proteinLetters = {"A", "R", "N", "D", "C", "Q", "E", "G", "H", "I", "L", "K", "M", "F", "P", "S", "T", "W", "Y", "V"};
        
        for (int i = 0; i < sequenceString.length(); i++) {
            if(initialCharArray[i] == Parser.DASH){
                output += "-";
            } else {
                output += proteinLetters[initialCharArray[i]];
            }
        }
        return output;
    }
    
    
    
    
    
}
