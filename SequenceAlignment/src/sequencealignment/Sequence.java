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
    
    Sequence(String sequenceString){
        this.sequenceString=sequenceString;
    }
    
    void setSequence(String sequenceString){
        this.sequenceString=sequenceString;
    }
    
    void appendSequence(String appendString){
        sequenceString+=appendString;
    }
    
    String getSequence(){
        return sequenceString;
    }
    
    String getSequence(int startIndex, int stopIndex){
        return sequenceString.substring(startIndex, stopIndex);
    }
}
