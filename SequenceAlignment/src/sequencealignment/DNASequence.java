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
public class DNASequence extends NucleotideSequence {
    public DNASequence(String sequenceString){
        super(sequenceString);
    }
    
    @Override
    String toReadable(){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";
        
        for (int i = 0; i < sequenceString.length(); i++) {
            switch(initialCharArray[i]){
                case 0:
                    output += "A";
                    break;
                case 1:
                    output += "T";
                    break;
                case 2:
                    output += "C";
                    break;
                case 3:
                    output += "G";
                    break;
                case Character.MAX_VALUE:
                    output += "-";
                    break;
            }
        }
        return output;
    }
}
