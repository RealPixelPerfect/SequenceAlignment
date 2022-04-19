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
public class Sequence {

    protected String sequenceString;

    Sequence(String sequenceString) {
        this.sequenceString = sequenceString;
    }

    void setSequence(String sequenceString) {
        this.sequenceString = sequenceString;
    }

    void appendSequence(String appendString) {
        sequenceString += appendString;
    }

    String getSequence() {
        return sequenceString;
    }

    String getSequence(int startIndex, int stopIndex) {
        return sequenceString.substring(startIndex, stopIndex);
    }

    String toReadable() {
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";

        for (int i = 0; i < sequenceString.length(); i++) {
            if (initialCharArray[i] == Parser.DASH) {
                output += "-";
            } else {
                output += String.valueOf((int) initialCharArray[i]);
            }
        }
        return output;
    }
    
    String flip(String type){
        char[] initialCharArray = sequenceString.toCharArray();
        String output = "";
        
        for (int i = 0; i < sequenceString.length(); i++) {
            if (initialCharArray[i] == 'C') {
                output += 'G';
            }else if (initialCharArray[i] == 'G') {
                output += 'C';
            }else if (initialCharArray[i] == 'A') {
                if(type == "DNA"){
                    output += 'T';
                } else {
                    output += 'U';
                }
            }else if (initialCharArray[i] == 'T' || initialCharArray[i] == 'U') {
                output += 'A';
            }
        }

        return output;
    };
}
