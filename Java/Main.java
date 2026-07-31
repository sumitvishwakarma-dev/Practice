// Online Java Compiler
// Use this editor to write, compile and run your Java code online

class Main {
    public static void main(String[] args) {
        System.out.println("Start small. Ship something.");

        int [] number = new int[10];
        number[0]=18;
        number[1]=30;
        number[2]=40;
        number[5]=60;
        for(int i=0;i< number.length;i++)
            System.out.print(" " +number[i]);



        //Array Initialization
        int num[] ={20,30,70,37};
        for(int i=0;i<num.length;i++)
            System.out.println(" "+num[i]);


        //Dynamically column assigned in 2D array

        int [][] marks = new int[5][];
        int col=2;
        int row =0 ;
            for (; col<20 && row < 5; ){
                marks[row++] = new int[col+=row];
            }
            System.out.println();
        System.out.println("Size of Array marks :: " + marks[1].length);

        int x=101;
        for(int assignRow =0; assignRow< marks.length; assignRow++){
            for(int assignCol=0 ; assignCol<marks[assignRow].length ; assignCol++){
                marks[assignRow][assignCol] = x;
                x++;
            }
        }

        for(int i=0; i< marks.length; i++){
            for(int j=0; j<marks[i].length ;j++){
                System.out.print(" " +marks[i][j] );
            }
            System.out.println();
        }
        System.out.println("Elemwnt at marks[1][2] is ::"+marks[1][2]);

    }
}