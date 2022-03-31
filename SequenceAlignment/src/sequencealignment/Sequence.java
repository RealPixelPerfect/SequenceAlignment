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
}
