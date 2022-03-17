/*
 * 
 * Free to share, use and modify.
 * 
 */
package sequencealignment;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author love
 */
public class Aligner {
    
    //static HashMap<String, Integer> dnaSubstitutionMatrix= new HashMap<>();
    static final int[][] dnaSubstitutionMatrix= 
    {{2, 1,-1,-1},
    { 1, 2,-1,-1},
    {-1,-1, 2, 1},
    {-1,-1, 1, 2}};
    
    static final int gap=-1;
    
    static final int[][] proteinSubstitutionMatrix={
            { 4,-1,-2,-2, 0,-1,-1, 0,-2,-1,-1,-1,-1,-2,-1, 1, 0,-3,-2, 0,-2,-1,-1,-1,-4},
            {-1, 5, 0,-2,-3, 1, 0,-2, 0,-3,-2, 2,-1,-3,-2,-1,-1,-3,-2,-3,-1,-2, 0,-1,-4},
            {-2, 0, 6, 1,-3, 0, 0, 0, 1,-3,-3, 0,-2,-3,-2, 1, 0,-4,-2,-3, 4,-3, 0,-1,-4},
            {-2,-2, 1, 6,-3, 0, 2,-1,-1,-3,-4,-1,-3,-3,-1, 0,-1,-4,-3,-3, 4,-3, 1,-1,-4},
            { 0,-3,-3,-3, 9,-3,-4,-3,-3,-1,-1,-3,-1,-2,-3,-1,-1,-2,-2,-1,-3,-1,-3,-1,-4},
            {-1, 1, 0, 0,-3, 5, 2,-2, 0,-3,-2, 1, 0,-3,-1, 0,-1,-2,-1,-2, 0,-2, 4,-1,-4},
            {-1, 0, 0, 2,-4, 2, 5,-2, 0,-3,-3, 1,-2,-3,-1, 0,-1,-3,-2,-2, 1,-3, 4,-1,-4},
            { 0,-2, 0,-1,-3,-2,-2, 6,-2,-4,-4,-2,-3,-3,-2, 0,-2,-2,-3,-3,-1,-4,-2,-1,-4},
            {-2, 0, 1,-1,-3, 0, 0,-2, 8,-3,-3,-1,-2,-1,-2,-1,-2,-2, 2,-3, 0,-3, 0,-1,-4},
            {-1,-3,-3,-3,-1,-3,-3,-4,-3, 4, 2,-3, 1, 0,-3,-2,-1,-3,-1, 3,-3, 3,-3,-1,-4},
            {-1,-2,-3,-4,-1,-2,-3,-4,-3, 2, 4,-2, 2, 0,-3,-2,-1,-2,-1, 1,-4, 3,-3,-1,-4},
            {-1, 2, 0,-1,-3, 1, 1,-2,-1,-3,-2, 5,-1,-3,-1, 0,-1,-3,-2,-2, 0,-3, 1,-1,-4},
            {-1,-1,-2,-3,-1, 0,-2,-3,-2, 1, 2,-1, 5, 0,-2,-1,-1,-1,-1, 1,-3, 2,-1,-1,-4},
            {-2,-3,-3,-3,-2,-3,-3,-3,-1, 0, 0,-3, 0, 6,-4,-2,-2, 1, 3,-1,-3, 0,-3,-1,-4},
            {-1,-2,-2,-1,-3,-1,-1,-2,-2,-3,-3,-1,-2,-4, 7,-1,-1,-4,-3,-2,-2,-3,-1,-1,-4},
            { 1,-1, 1, 0,-1, 0, 0, 0,-1,-2,-2, 0,-1,-2,-1, 4, 1,-3,-2,-2, 0,-2, 0,-1,-4},
            { 0,-1, 0,-1,-1,-1,-1,-2,-2,-1,-1,-1,-1,-2,-1, 1, 5,-2,-2, 0,-1,-1,-1,-1,-4},
            {-3,-3,-4,-4,-2,-2,-3,-2,-2,-3,-2,-3,-1, 1,-4,-3,-2,11, 2,-3,-4,-2,-2,-1,-4},
            {-2,-2,-2,-3,-2,-1,-2,-3, 2,-1,-1,-2,-1, 3,-3,-2,-2, 2, 7,-1,-3,-1,-2,-1,-4},
            { 0,-3,-3,-3,-1,-2,-2,-3,-3, 3, 1,-2, 1,-1,-2,-2, 0,-3,-1, 4,-3, 2,-2,-1,-4},
            {-2,-1, 4, 4,-3, 0, 1,-1, 0,-3,-4, 0,-3,-3,-2, 0,-1,-4,-3,-3, 4,-3, 0,-1,-4},
            {-1,-2,-3,-3,-1,-2,-3,-4,-3, 3, 3,-3, 2, 0,-3,-2,-1,-2,-1, 2,-3, 3,-3,-1,-4},
            {-1, 0, 0, 1,-3, 4, 4,-2, 0,-3,-3, 1,-1,-3,-1, 0,-1,-2,-2,-2, 0,-3, 4,-1,-4},
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-4},
            {-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4,-4, 1}
    };
    
    ArrayList<DNASequence> needlemanWunsch(ArrayList<DNASequence> sequenceArray){
        if(sequenceArray.size()<2){
            return null;
        } else if(sequenceArray.size()==2){
            class Match{
            
            Match(int score, char origin){
                this.score=score;
                this.origin=origin;
            }
            
            int score=0;
            char origin; //u: up, d: diagonal, l: left, s: start
        }
            String sequence1=sequenceArray.get(0).getSequence();
            int sequence1Size=sequence1.length();
            String sequence2=sequenceArray.get(1).getSequence();
            int sequence2Size=sequence2.length();
            System.out.print("Seq1: ");
            for(char c:sequence1.toCharArray()){
                System.out.print((int)c);
            }
            System.out.println();
            System.out.print("Seq2: ");
            for(char c:sequence2.toCharArray()){
                System.out.print((int)c);
            }
            System.out.println();
            ArrayList<DNASequence> returnArray = new ArrayList<>();
            HashMap<Point,Match> alignmentGrid = new HashMap();
            //Set edges first
            Match upperLeftCorner = new Match(0,'s');
            alignmentGrid.put(new Point(0,0), upperLeftCorner);
            int edgeScore=gap;
            for(int column=1;column<sequence2Size+1;column++){
                Match edgeMatch = new Match(edgeScore,'l');
                alignmentGrid.put(new Point(0,column), edgeMatch);
                edgeScore+=gap;
            }
            edgeScore=gap;
            for(int row=1;row<sequence1Size+1;row++){
                Match edgeMatch=new Match(edgeScore,'u');
                alignmentGrid.put(new Point(row,0), edgeMatch);
                edgeScore+=gap;
            }
            for (Point p:alignmentGrid.keySet()){
                char origin=alignmentGrid.get(p).origin;
                System.out.println("row: "+p.x+" column: "+p.y+" value: "+alignmentGrid.get(p).score+" origin: "+origin);
            }
            
            //Fill out the rest of the matrix one row at a time
            //Matchningar som inte används kan ignoreras
            //Ger NullPointerException
            for(int row=1;row<sequence1Size+1;row++){
                for(int column=1;column<sequence2Size+1;column++){
                    System.out.println("row: "+row+" column: "+column);
                    Match down=alignmentGrid.get(new Point(row-1,column));
                    int downScore=down.score+gap;
                    Match diagonal=alignmentGrid.get(new Point(row-1,column-1));
                    int base1=(int)sequence1.charAt(row-1);
                    int base2=(int)sequence1.charAt(column-1);
                    int diagonalScore=diagonal.score+dnaSubstitutionMatrix[base1][base2];
                    Match right=alignmentGrid.get(new Point(row,column-1));
                    int rightScore=right.score+gap;
                    int currentScore;
                    char currentOrigin;
                    if(diagonalScore>=downScore&&diagonalScore>=rightScore){
                        currentScore=diagonalScore;
                        currentOrigin='d';
                        System.out.println("diagonal is best");
                    } else if(downScore>=rightScore){
                        currentScore=downScore;
                        currentOrigin='u';
                        System.out.println("down is best");
                    } else{
                        currentScore=rightScore;
                        currentOrigin='l';
                        System.out.println("right is best");
                    }
                    alignmentGrid.put(new Point(row,column), new Match(currentScore, currentOrigin));
                }
            }
            
            //Trace path backwards
            String alignedSequence1="";
            String alignedSequence2="";
            char direction;
            int row=sequence1Size;
            int column=sequence2Size;
            boolean stop=false;
            do{
                Match currentMatch=alignmentGrid.get(new Point(row,column));
                direction=currentMatch.origin;
                switch (direction){
                    case 'd':
                        System.out.println("d");
                        alignedSequence1=sequence1.charAt(row-1)+alignedSequence1;
                        alignedSequence2=sequence2.charAt(column-1)+alignedSequence2;
                        row--;
                        column--;
                        break;
                    case 'u':
                        System.out.println("u");
                        alignedSequence1=sequence1.charAt(row-1)+alignedSequence1;
                        alignedSequence2=(char)-1+alignedSequence2;
                        row--;
                        break;
                    case 'l':
                        System.out.println("l");
                        alignedSequence1=(char)-1+alignedSequence1;
                        alignedSequence2=sequence2.charAt(column-1)+alignedSequence2;
                        column--;
                        break;
                }
            }while(direction!='s');
            
            returnArray.add(new DNASequence(alignedSequence1));
            returnArray.add(new DNASequence(alignedSequence2));
            
            //Calculate the best path for each point
            /*ATGATCGATCGATC
              ATAGATCGATCT
            
               0   A   T   A   C   G   G   G   C   T   A   A   C
            0  0  -1  -2  -3  -4  -5  -6  -7  -8  -9  -10 -11 -12
                                                                
            T -1   1   1
                                                                  
            G -2
                                                                  
            G -3
                                                                
            A -4
                                                                  
            A -5
                                                                  
            C -6
                                                                  
            G -7
                                                                       
            C -8
                                                                    
            C -9
                                                                              
            T -10
                                                                         
            A -11
            
            
               0  A  T  A  C  G  G  G  C  T  A  A  C
            0  
            
            T
            
            G
            
            G
            
            A
            
            A
            
            C
            
            G
            
            C
            
            C
            
            T
            
            A
            
            */
            
            return returnArray;
        } else{
            return null;
        }
    }
}
