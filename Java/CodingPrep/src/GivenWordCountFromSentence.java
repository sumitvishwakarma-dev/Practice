public class GivenWordCountFromSentence {

    public static void main(String[] args) {
            String sentence = "Sumit Sleep, Sumit! ! Slap Sumit? nap Sumit dumb";
            String word = "Sumit";

            int count = countWord(sentence, word);
            System.out.println("Count is : "+count);
        }

        public static int countWord(String sentence, String word){

            String [] words = sentence.split("[^a-zA-Z]+");
            int count=0;

            for(String w : words){
                if(w.equals(word)){
                    count++;
                }
            }
            return count;
        }
}
