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
public class RNASequence extends Sequence {

    public RNASequence(String sequenceString) {
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
                    output += "U";
                    break;
                case 2:
                    output += "C";
                    break;
                case 3:
                    output += "G";
                    break;
                case Parser.DASH:
                    output += "-";
                    break;
            }
        }
        return output;
    }
    
}
