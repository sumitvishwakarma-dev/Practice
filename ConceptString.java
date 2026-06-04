public class ConceptString {

    void main(){

        StringBuilder sb = new StringBuilder("Sumit");
        System.out.println(sb);
        StringBuffer stb = new StringBuffer("Amit");
        System.out.println(stb.length());
        String str = new String("     ");
        System.out.println("::::: String is having 5 Blank Spaces :::::" +str);
        System.out.println("Lengh " +str.length());
        System.out.println("Empty " +str.isEmpty());
        System.out.println("Blank " +str.isBlank());


        String str2 = new String("Abhimanyu");
        char [] charStr = str2.toCharArray();
        System.out.println("chsr at :: "+charStr[0]);



    }
}
