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
    static final int[][] DNA_SUBSTITUTION_MATRIX= 
    {{2, 1,-1,-1},
    { 1, 2,-1,-1},
    {-1,-1, 2, 1},
    {-1,-1, 1, 2}};
    
    static final int[][] RNA_SUBSTITUTION_MATRIX= 
    {{2, 1,-1,-1},
    { 1, 2,-1,-1},
    {-1,-1, 2, 1},
    {-1,-1, 1, 2}};
    
    static final int gap=-1;
    
    static final int[][] PROTEIN_SUBSTITUTION_MATRIX={
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
    
    /*ArrayList<DNASequence> needlemanWunsch(ArrayList<DNASequence> sequenceArray){ //Fixa så att den går baklänges och funkar för RNA och proteiner
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
            //System.out.print("Seq1: ");
            /*for(char c:sequence1.toCharArray()){
                System.out.print((int)c);
            }*/
            //System.out.println();
            //System.out.print("Seq2: ");
            /*for(char c:sequence2.toCharArray()){
                System.out.print((int)c);
            }*//*
            //System.out.println();
            ArrayList<DNASequence> returnArray = new ArrayList<>();
            HashMap<Point,Match> alignmentGrid = new HashMap();
            //Set edges first
            Match bottomRightCorner = new Match(0,'s');
            alignmentGrid.put(new Point(sequence1Size,sequence2Size), bottomRightCorner);
            int edgeScore=gap;
            for(int column=sequence2Size;column>=0;column--){
                Match edgeMatch = new Match(edgeScore,'l');
                alignmentGrid.put(new Point(sequence1Size,column), edgeMatch);
                edgeScore+=gap;
            }
            edgeScore=gap;
            for(int row=sequence1Size;row>=0;row--){
                Match edgeMatch=new Match(edgeScore,'u');
                alignmentGrid.put(new Point(row,sequence2Size), edgeMatch);
                edgeScore+=gap;
            }
            for (Point p:alignmentGrid.keySet()){
                char origin=alignmentGrid.get(p).origin;
                System.out.println("row: "+p.x+" column: "+p.y+" value: "+alignmentGrid.get(p).score+" origin: "+origin);
            }
            
            //Fill out the rest of the matrix one row at a time
            //Matchningar som inte används kan ignoreras
            //Ger NullPointerException
            for(int row=sequence1Size-1;row>=0;row--){
                for(int column=sequence2Size-1;column>=0;column--){
                    System.out.println("row: "+row+" column: "+column);
                    Match down=alignmentGrid.get(new Point(row+1,column));
                    int downScore=down.score+gap;
                    Match diagonal=alignmentGrid.get(new Point(row+1,column+1));
                    int base1=(int)sequence1.charAt(row);
                    int base2=(int)sequence2.charAt(column);
                    int diagonalScore=diagonal.score+dnaSubstitutionMatrix[base1][base2];
                    System.out.println("base1: "+base1+ " base2: "+base2);
                    Match right=alignmentGrid.get(new Point(row+1,column));
                    int rightScore=right.score+gap;
                    System.out.println("Downscore: "+downScore+" diagonalScore: "+diagonalScore+ " rightscore: "+rightScore);
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
            
            for(int row=0;row<8;row++){
                for(int column=0;column<13;column++){
                    Point p = new Point(row,column);
                    System.out.print(alignmentGrid.get(p).score);
                }
                System.out.println();
            }
            
            //Trace path backwards
            /*
            String alignedSequence1="";
            String alignedSequence2="";
            char direction;
            int row=0;
            int column=0;
            do{
                System.out.println("row: "+row+" column: "+column);
                Match currentMatch=alignmentGrid.get(new Point(row,column));
                direction=currentMatch.origin;
                switch (direction){
                    case 'd':
                        System.out.println("d");
                        alignedSequence1+=sequence1.charAt(row);
                        alignedSequence2+=sequence2.charAt(column);
                        row++;
                        column++;
                        break;
                    case 'u':
                        System.out.println("u");
                        alignedSequence1+=sequence1.charAt(row+1);
                        alignedSequence2+=Parser.DASH;
                        row++;
                        break;
                    case 'l':
                        System.out.println("l");
                        alignedSequence1+=Parser.DASH;
                        alignedSequence2+=sequence2.charAt(column+1);
                        column++;
                        break;
                }
            }while(direction!='s');
            
            returnArray.add(new DNASequence(alignedSequence1));
            returnArray.add(new DNASequence(alignedSequence2));*/
            
            //Calculate the best path for each point
            /*
            
            0,1,0,2,3,3,3,2,1,0,0,2
            1,3,3,0,0,2,3
            
               0   A   T   A   C   G   G   G   C   T   A   A   C
            0  0 >-1 >-2 >-3 >-4 >-5 >-6 >-7 >-8 >-9 >-10>-11>-12
               | \   \                                          
            T -1   1   1 > 0 >-1 >-2 >-3 >-4 >-5 >-6 >-7 >-8 >-9   
               |   |   | \   \   \   \   \                        
            G -2   0   0   0   1   1 > 0  -1 >-2 >-3 >-4 >-5 >-6
               |   | \   \   \   \   \   \                        
            G -3  -1  -1  -1   1   3   3   2 > 1 > 0 >-1 >-2 >-3
               | \   \   \     |   | \   \   \   \   \   \      
            A -4  -1   0   1   0   2   2   2   1   2   2   1 > 0
               | \   \   \   \     |   |   |   | \   \   \    
            A -5  -2   0   2   0   1   1   1   0   2   4   4 > 3
               |   |   |   | \       \   \   \         |   | \    
            C -6  -3  -1   1   4 > 3   2   2   3 > 2   3   3   5
               |   |   | \     | \   \   \   \   \     |   | \    
            G -7  -4  -2   0   3   6   5   4   3   2   2   2   4
            
               A   T   A   C   G   G   G   C   T   A   A   C   0
            
            T 
              
            G 
              
            G 
              
            A 
              
            A 
                   
            C 
              
            G 
            
            0                                                   
            
            *//*
            
            return returnArray;
        } else{
            return null;
        }
    }*/
    
    class Match{ //Match for needlemanWunsch
            Match(int score, char origin){
                this.score=score;
                this.origin=origin;
            }
            int score=0;
            char origin; //u: up, d: diagonal, l: left, s: start
            }
    
    void setEdges(HashMap<Point,Match> map, int rows, int columns){
        Match upperLeftCorner = new Match(0,'s');
            map.put(new Point(0,0), upperLeftCorner);
            int edgeScore=gap;
            for(int column=1;column<columns;column++){
                Match edgeMatch = new Match(edgeScore,'l');
                map.put(new Point(0,column), edgeMatch);
                edgeScore+=gap;
            }
            edgeScore=gap;
            for(int row=1;row<rows;row++){
                Match edgeMatch=new Match(edgeScore,'u');
                map.put(new Point(row,0), edgeMatch);
                edgeScore+=gap;
            }
            /*for (Point p:alignmentGrid.keySet()){
                char origin=alignmentGrid.get(p).origin;
                //System.out.println("row: "+p.x+" column: "+p.y+" value: "+alignmentGrid.get(p).score+" origin: "+origin);
            }*/
    }
    
    String[] tracebackNeedlemanWunsch(HashMap<Point,Match> map, int startRow, int startColumn,String sequence1,String sequence2){
        String alignedSequence1="";
            String alignedSequence2="";
            char direction;
            int row=startRow;
            int column=startColumn;
            do{
                Match currentMatch=map.get(new Point(row,column));
                direction=currentMatch.origin;
                switch (direction){
                    case 'd':
                        //System.out.println("d");
                        alignedSequence1=sequence1.charAt(row-1)+alignedSequence1;
                        alignedSequence2=sequence2.charAt(column-1)+alignedSequence2;
                        row--;
                        column--;
                        break;
                    case 'u':
                        //System.out.println("u");
                        alignedSequence1=sequence1.charAt(row-1)+alignedSequence1;
                        alignedSequence2=Parser.DASH+alignedSequence2;
                        row--;
                        break;
                    case 'l':
                        //System.out.println("l");
                        alignedSequence1=(char)-1+alignedSequence1;
                        alignedSequence2=sequence2.charAt(column-1)+alignedSequence2;
                        column--;
                        break;
                }
            }while(direction!='s');
        String[] returnArray={alignedSequence1,alignedSequence2};
        return returnArray;
    }
    
    DNASequence[] needlemanWunsch(DNASequence[] sequenceArray){
        if(sequenceArray.length<2){
            return null;
        } else if(sequenceArray.length==2){
            String sequence1=sequenceArray[0].getSequence();
            int sequence1Size=sequence1.length();
            String sequence2=sequenceArray[1].getSequence();
            int sequence2Size=sequence2.length();
            //System.out.print("Seq1: ");
            /*for(char c:sequence1.toCharArray()){
                System.out.print((int)c);
            }*/
            //System.out.println();
            //System.out.print("Seq2: ");
            /*for(char c:sequence2.toCharArray()){
                System.out.print((int)c);
            }*/
            //System.out.println();
            HashMap<Point,Match> alignmentGrid = new HashMap();
            //Set edges first
            setEdges(alignmentGrid,sequence1Size+1,sequence2Size+1);
            
            //Fill out the rest of the matrix one row at a time
            //Matchningar som inte används kan ignoreras
            for(int row=1;row<sequence1Size+1;row++){
                for(int column=1;column<sequence2Size+1;column++){
                    //System.out.println("row: "+row+" column: "+column);
                    Match down=alignmentGrid.get(new Point(row-1,column));
                    int downScore=down.score+gap;
                    Match diagonal=alignmentGrid.get(new Point(row-1,column-1));
                    int base1=(int)sequence1.charAt(row-1);
                    int base2=(int)sequence2.charAt(column-1);
                    int diagonalScore=0;
                    diagonalScore=diagonal.score+DNA_SUBSTITUTION_MATRIX[base1][base2];
                    //System.out.println("base1: "+base1+ " base2: "+base2);
                    Match right=alignmentGrid.get(new Point(row,column-1));
                    int rightScore=right.score+gap;
                    //System.out.println("Downscore: "+downScore+" diagonalScore: "+diagonalScore+ " rightscore: "+rightScore);
                    int currentScore;
                    char currentOrigin;
                    if(diagonalScore>=downScore&&diagonalScore>=rightScore){
                        currentScore=diagonalScore;
                        currentOrigin='d';
                        //System.out.println("diagonal is best");
                    } else if(downScore>=rightScore){
                        currentScore=downScore;
                        currentOrigin='u';
                        //System.out.println("down is best");
                    } else{
                        currentScore=rightScore;
                        currentOrigin='l';
                        //System.out.println("right is best");
                    }
                    alignmentGrid.put(new Point(row,column), new Match(currentScore, currentOrigin));
                }
            }
            //Trace path backwards
            String[] alignedSequences=tracebackNeedlemanWunsch(alignmentGrid, sequence1Size, sequence2Size,sequence1,sequence2);
            String alignedSequence1=alignedSequences[0];
            String alignedSequence2=alignedSequences[1];
            //Fixa så att rätt typ av sekvens returneras
            DNASequence[] returnArray = {new DNASequence(alignedSequence1),new DNASequence(alignedSequence2)};
            return returnArray;
            
            
            
        } else{
            return null;
        }
    }
    
    RNASequence[] needlemanWunsch(RNASequence[] sequenceArray){
        if(sequenceArray.length<2){
            return null;
        } else if(sequenceArray.length==2){
            String sequence1=sequenceArray[0].getSequence();
            int sequence1Size=sequence1.length();
            String sequence2=sequenceArray[1].getSequence();
            int sequence2Size=sequence2.length();
            //System.out.print("Seq1: ");
            /*for(char c:sequence1.toCharArray()){
                System.out.print((int)c);
            }*/
            //System.out.println();
            //System.out.print("Seq2: ");
            /*for(char c:sequence2.toCharArray()){
                System.out.print((int)c);
            }*/
            //System.out.println();
            HashMap<Point,Match> alignmentGrid = new HashMap();
            //Set edges first
            setEdges(alignmentGrid,sequence1Size+1,sequence2Size+1);
            
            //Fill out the rest of the matrix one row at a time
            //Matchningar som inte används kan ignoreras
            for(int row=1;row<sequence1Size+1;row++){
                for(int column=1;column<sequence2Size+1;column++){
                    //System.out.println("row: "+row+" column: "+column);
                    Match down=alignmentGrid.get(new Point(row-1,column));
                    int downScore=down.score+gap;
                    Match diagonal=alignmentGrid.get(new Point(row-1,column-1));
                    int base1=(int)sequence1.charAt(row-1);
                    int base2=(int)sequence2.charAt(column-1);
                    int diagonalScore=0;
                    diagonalScore=diagonal.score+RNA_SUBSTITUTION_MATRIX[base1][base2];
                    //System.out.println("base1: "+base1+ " base2: "+base2);
                    Match right=alignmentGrid.get(new Point(row,column-1));
                    int rightScore=right.score+gap;
                    //System.out.println("Downscore: "+downScore+" diagonalScore: "+diagonalScore+ " rightscore: "+rightScore);
                    int currentScore;
                    char currentOrigin;
                    if(diagonalScore>=downScore&&diagonalScore>=rightScore){
                        currentScore=diagonalScore;
                        currentOrigin='d';
                        //System.out.println("diagonal is best");
                    } else if(downScore>=rightScore){
                        currentScore=downScore;
                        currentOrigin='u';
                        //System.out.println("down is best");
                    } else{
                        currentScore=rightScore;
                        currentOrigin='l';
                        //System.out.println("right is best");
                    }
                    alignmentGrid.put(new Point(row,column), new Match(currentScore, currentOrigin));
                }
            }
            //Trace path backwards
            String[] alignedSequences=tracebackNeedlemanWunsch(alignmentGrid, sequence1Size, sequence2Size,sequence1,sequence2);
            String alignedSequence1=alignedSequences[0];
            String alignedSequence2=alignedSequences[1];
            //Fixa så att rätt typ av sekvens returneras
            RNASequence[] returnArray = {new RNASequence(alignedSequence1),new RNASequence(alignedSequence2)};
            return returnArray;
            
            
            
        } else{
            return null;
        }
    }
    
    ProteinSequence[] needlemanWunsch(ProteinSequence[] sequenceArray){
        if(sequenceArray.length<2){
            return null;
        } else if(sequenceArray.length==2){
            String sequence1=sequenceArray[0].getSequence();
            int sequence1Size=sequence1.length();
            String sequence2=sequenceArray[1].getSequence();
            int sequence2Size=sequence2.length();
            HashMap<Point,Match> alignmentGrid = new HashMap();
            
            setEdges(alignmentGrid,sequence1Size+1,sequence2Size+1);
            
            //Fill out the rest of the matrix one row at a time
            for(int row=1;row<sequence1Size+1;row++){
                for(int column=1;column<sequence2Size+1;column++){
                    //System.out.println("row: "+row+" column: "+column);
                    Match down=alignmentGrid.get(new Point(row-1,column));
                    int downScore=down.score+gap;
                    Match diagonal=alignmentGrid.get(new Point(row-1,column-1));
                    int base1=(int)sequence1.charAt(row-1);
                    int base2=(int)sequence2.charAt(column-1);
                    int diagonalScore=0;
                    diagonalScore=diagonal.score+PROTEIN_SUBSTITUTION_MATRIX[base1][base2];
                    //System.out.println("base1: "+base1+ " base2: "+base2);
                    Match right=alignmentGrid.get(new Point(row,column-1));
                    int rightScore=right.score+gap;
                    //System.out.println("Downscore: "+downScore+" diagonalScore: "+diagonalScore+ " rightscore: "+rightScore);
                    int currentScore;
                    char currentOrigin;
                    if(diagonalScore>=downScore&&diagonalScore>=rightScore){
                        currentScore=diagonalScore;
                        currentOrigin='d';
                        //System.out.println("diagonal is best");
                    } else if(downScore>=rightScore){
                        currentScore=downScore;
                        currentOrigin='u';
                        //System.out.println("down is best");
                    } else{
                        currentScore=rightScore;
                        currentOrigin='l';
                        //System.out.println("right is best");
                    }
                    alignmentGrid.put(new Point(row,column), new Match(currentScore, currentOrigin));
                }
            }
            //Trace path backwards
            String[] alignedSequences=tracebackNeedlemanWunsch(alignmentGrid, sequence1Size, sequence2Size,sequence1,sequence2);
            String alignedSequence1=alignedSequences[0];
            String alignedSequence2=alignedSequences[1];
            //Fixa så att rätt typ av sekvens returneras
            ProteinSequence[] returnArray = {new ProteinSequence(alignedSequence1),new ProteinSequence(alignedSequence2)};
            return returnArray;
            
            
            
        } else{
            return null;
        }
    }
}

//Calculate the best path for each point
            /*
            
            010233321002
            1330023
            
               0   A   T   A   C   G   G   G   C   T   A   A   C
            0  0 >-1 >-2 >-3 >-4 >-5 >-6 >-7 >-8 >-9 >-10>-11>-12
               | \   \                                          
            T -1   1   1 > 0 >-1 >-2 >-3 >-4 >-5 >-6 >-7 >-8 >-9   
               |   |   | \   \   \   \   \                        
            G -2   0   0   0   1   1 > 0  -1 >-2 >-3 >-4 >-5 >-6
               |   | \   \   \   \   \   \                        
            G -3  -1  -1  -1   1   3   3   2 > 1 > 0 >-1 >-2 >-3
               | \   \   \     |   | \   \   \   \   \   \      
            A -4  -1   0   1   0   2   2   2   1   2   2   1 > 0
               | \   \   \   \     |   |   |   | \   \   \    
            A -5  -2   0   2   0   1   1   1   0   2   4   4 > 3
               |   |   |   | \       \   \   \         |   | \    
            C -6  -3  -1   1   4 > 3   2   2   3 > 2   3   3   5
               |   |   | \     | \   \   \   \   \     |   | \    
            G -7  -4  -2   0   3   6   5   4   3   2   2   2   4*/