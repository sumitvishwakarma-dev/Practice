import javax.swing.plaf.synth.SynthOptionPaneUI;

class CallByRef{
    void main()
    {
        int x=10,y=40;
        Random rNum= new Random(x,y);
        System.out.println("Before X: "+rNum.x+"\tY: "+rNum.y);
        addValue(rNum);
        IO.println("After X: "+rNum.x+"\tY: "+rNum.y);
        Random rNum1 = new Random(rNum.x, rNum.y);
        Random rNumReturn = addRandom(rNum1);

        IO.println("After Random return X added 40: "+rNumReturn.x+"\tY added 60: "+rNumReturn.y);


    }

    void addValue(Random paraNum){
        paraNum.x = paraNum.x + 15;
        paraNum.y = paraNum.y + 25;
    }

    Random addRandom(Random paraNum){
        paraNum.x = paraNum.x + 40;
        paraNum.y = paraNum.y + 60;
        return paraNum;
    }

}
class Random{
    int x,y;
    Random(int x , int y){
        this.x=x;
        this.y=y;
    }
}