import java.util.Random;
import java.io.Console;

public class Utils {
	public static final Random generator = new Random();
	public static final Console console = System.console();
	public static final String NEW_LINE = System.getProperty("line.separator");


    /**
     * This method rotates array of size lines * columns referenced
     * by transformedBoard by 90 degree clockwise. For example, the
     * 3*3 game
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method rotates it into the game
     *
     * 7 | 4 | 1
     * ----------
     * 8 | 5 | 2
     * ----------
     * 9 | 6 | 3
     *
     * that is, after the method, transformedBoard = {7,4,1,8,5,2,9,6,3}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */


    public static void rotate(int lines, int columns, int[] transformedBoard){

            // YOUR CODE HERE
						if(!(lines == columns))return;
						int coin1 = 0;
						int coin2 = columns-1;
						int coin3 = (columns-1)*columns;
						int coin4 = columns * lines - 1;
						for(int i = 0; i < lines/2; i++){
							int[] temp1 = new int[lines];
							int[] temp2 = new int[lines];
							int modI = columns * i;
							int tempIndex1 = coin1 + modI + i;
							int tempIndex2 = coin2 + modI - i;
							int tempIndex3 = coin3 - modI + i;
							int tempIndex4 = coin4 - modI - i;
							for(int j = 0+i; j < lines-i-1; j++){
								int modJ = j * columns;
								int nextIndex1 = tempIndex1 + j;
								int nextIndex2 = tempIndex2 + modJ;
								int nextIndex3 = tempIndex3 - modJ;
								int nextIndex4 = tempIndex4 - j;
								temp1[j] = transformedBoard[nextIndex1];
								temp2[j] = transformedBoard[nextIndex4];
								transformedBoard[nextIndex1] = transformedBoard[nextIndex3];
								transformedBoard[nextIndex4] = transformedBoard[nextIndex2];
								transformedBoard[nextIndex2] = temp1[j];
								transformedBoard[nextIndex3] = temp2[j];
							}
						}

    }

    /**
     * This method does an horizontal symmetry on array of size lines * columns referenced
     * by transformedBoard. For example, the
     * 3*3 game
     *
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method transforms it into the game
     *
     * 7 | 8 | 9
     * ----------
     * 4 | 5 | 6
     * ----------
     * 1 | 2 | 3
     *
     * that is, after the method, transformedBoard = {7,8,9,4,5,6,1,2,3}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */

    public static  void horizontalFlip(int lines, int columns, int[] transformedBoard){

        // YOUR CODE HERE
				for(int i = 0; i < lines/2 ; i++){
					//lines max = 3 columns max = 3
					//lines * columns = 9
					//premiere valeur transformedBoard[calcul]
					//calcul =
					//transformedBoard[0-8] = 9 valeurs
					int[] temp = new int[columns];
					int positionEchange = i * columns;// emple table 5 columns 6 ligne: pos = 0, 5, 10.
					for(int j = 0; j < columns; j++){
						int tempIndex = j + positionEchange;
						int tempIndex2 = (lines - 1 - i) * columns + j;
						temp[j] = transformedBoard[tempIndex];
						transformedBoard[tempIndex] = transformedBoard[tempIndex2];
						transformedBoard[tempIndex2] = temp[j];
					}

				}
    }

   /**
     * This method does an vertical symmetry on array of size lines * columns referenced
     * by transformedBoard. For example, the
     * 3*3 game
     *
     * 1 | 2 | 3
     * ----------
     * 4 | 5 | 6
     * ----------
     * 7 | 8 | 9
     *
     * for which lines = 3 and columns = 3 is represented by the array
     * transformedBoard = {1,2,3,4,5,6,7,8,9}
     *
     * the method transforms it into the game
     *
     * 3 | 2 | 1
     * ----------
     * 6 | 5 | 4
     * ----------
     * 9 | 8 | 7
     *
     * that is, after the method, transformedBoard = {3,2,1,6,5,4,9,8,7}
     *
     * @param lines
     *  the number of lines in the game
     * @param columns
     *  the number of columns in the game
     * @param transformedBoard
     *  Reference to a 1 dimentional array of size columns x lines
     */

    public static  void verticalFlip(int lines, int columns, int[] transformedBoard){

        // YOUR CODE HERE
				for(int i = 0; i < columns/2; i++){


					int[] temp = new int[lines];
					//int positionEchange = i;
					for(int j = 0; j < lines; j++){
						int tempIndex = i + j*columns;
						int tempIndex2 = columns- 1 - i + j*columns;
						temp[j] = transformedBoard[tempIndex];
						transformedBoard[tempIndex] = transformedBoard[tempIndex2];
						transformedBoard[tempIndex2] = temp[j];
					}


				}

    }

    private static void test(int lines, int columns){
    	int[] test;
    	test = new int[lines*columns];
    	for(int i = 0 ; i < test.length; i++){
    		test[i] = i;
    	}
    	System.out.println("testing " + lines + " lines and " + columns + " columns.");
    	System.out.println(java.util.Arrays.toString(test));
    	horizontalFlip(lines,columns,test);
    	System.out.println("HF => " + java.util.Arrays.toString(test));
    	horizontalFlip(lines,columns,test);
    	System.out.println("HF => " + java.util.Arrays.toString(test));
    	verticalFlip(lines,columns,test);
    	System.out.println("VF => " + java.util.Arrays.toString(test));
    	verticalFlip(lines,columns,test);
    	System.out.println("VF => " + java.util.Arrays.toString(test));
    	if(lines == columns){
    		for(int i = 0; i < 4; i++) {
		    	rotate(lines,columns,test);
		    	System.out.println("ROT => " + java.util.Arrays.toString(test));
    		}
    	}
    }

    public static void main(String[] args){
    	int[] test;
    	int lines, columns;

    	test(2,2);
    	test(2,3);
    	test(3,3);
    	test(4,3);
    	test(4,4);


    }
}
