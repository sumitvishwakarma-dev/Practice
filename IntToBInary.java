public class IntToBInary {
    void main(){

        System.out.println(checkBi());

    }

    boolean checkBi(){
        String num = Integer.toBinaryString(12);
        char [] strNum = num.toCharArray();
//        String  numo = String.valueOf(strNum);
        int count=0;
        int length = strNum.length;
        for(int i=0;i<length-1;i++){
            System.out.println("::"+strNum[i]+" ::"+strNum[i+1]);
            boolean s1 =strNum[i]=='1';
            boolean s2 =strNum[i+1]=='1';
            if(strNum[i]== strNum[i+1]){
                if(strNum[i]=='1' && strNum[i+1]=='1'){
                    count++;
                }
            }
        }
        if(count > 1){
            return false;
        }
        else if(count == 1){
            return true;

        }else {
            return false;

        }
    }
}
