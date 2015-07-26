import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question 11.2
 * 
 * Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class AnagramSorterDemo {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please enter some words to sort. :-)");
        } else {
            sort(args);
        }
    }

    public static class Pair {
        private String mSortedString;
        private ArrayList<Integer> mPositions;

        public Pair(String key, int position) {
            init();

            mPositions.add(position);
            mSortedString = key;
        }

        public void init(){
            mPositions = new ArrayList<>();
        }

        public ArrayList<Integer> getPositions() {
            return mPositions;
        }

        public String getKey() {
            return mSortedString;
        }

        public void addPosition(int position) {
            mPositions.add(position);
        }
    }

    /**
     * Runtime O(n)
     * Memory O(n)
     * 
     * Definition a word is an anagram of another word if this new word is a rearrangement of the previous word.
     * i.e.
     * 1. Same length.
     * 2. Same number of characters.
     * 
     * Problem:
     * 1. Need to find all anagrams of a word.
     * 2. Need to sort all of them such that these anagrams are together.
     * 
     * PSEDOCODE:
     * 1.   Create a separate object (class: Pair) that contains the position of the word in the array (value)
     *      and its anagram (key) (sorted word).
     * 2.   Iterate through each word and sort its characters by alphabetical order.
     *      *   If dictionary contains a value with the sorted string, add the position to the Pair. otherwise
     *          add this value to the hashmap as the first value.
     * 3.   Once you iterate through each word, iterate through each Pair in the hashmap and print out the strings associated
     *      with those positions.
     */
    public static void sort(String[] array) {
        HashMap<String, Pair> dictionary = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            String word = array[i];

            String key = sortString(word);

            if (dictionary.containsKey(key)) {
                Pair pair = dictionary.get(key);
                pair.addPosition(i);
            } else {
                Pair newPair = new Pair(key, i);
                dictionary.put(key, newPair);
            }
        }

        StringBuffer buffer = new StringBuffer();
        for (Map.Entry entry : dictionary.entrySet()) {
            Pair pair = (Pair) entry.getValue();
        	System.out.println("Determining pairs for " + pair.getKey());

            for (Integer position : pair.getPositions()) {
                buffer.append(array[position] + " ");
            }
        }

        System.out.println(buffer.toString());
    }

    public static String sortString(String string) {
        // Right now this is using the JDK API to sort which
        // provides a runtime of O(n*log(n)).
        // This portion of the question would have also been a general
        // sorting problem itself and implemented manually.

        char[] chars = string.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
