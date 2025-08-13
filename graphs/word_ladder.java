import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;
import java.util.ArrayList;

public class word_ladder {
    static class pair{
        String word;
        int steps;
        public pair(String word,int steps){
            this.word = word;
            this.steps = steps;
        }
    }
    public static void main(String[] args) {
        String startWord = "hit";
        String targetWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = wordLadderLength(startWord, targetWord, wordList);
        System.out.println("Length of shortest transformation sequence: " + result); 
        ArrayList<ArrayList<String>> sequences = findSequences(startWord, targetWord, wordList);
        System.out.println("All sequences: " + sequences);
    }
    public static int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        Set<String> set = new HashSet<String>();
        for(int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(startWord,1));
        while(!q.isEmpty()){
            String word = q.peek().word;
            int steps = q.peek().steps;
            q.poll();
            if(word.equals(targetWord)) return steps;
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch <= 'z';ch++){
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new pair(newWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
    public static ArrayList<ArrayList<String>> findSequences(String startWord,
                                                      String targetWord,
                                                      String[] wordList) {
        // Code here
        Set<String> set = new HashSet<>();
        for(int i=0;i<wordList.length;i++){
            set.add(wordList[i]);
        }
        Queue<ArrayList<String>> q = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        q.offer(ls);
        ArrayList<String> usedOnlevel = new ArrayList<>();
        usedOnlevel.add(startWord);
        int level = 0;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        while(!q.isEmpty()){
            ArrayList<String> vec = q.poll();
            if(vec.size() > level){
                level++;
                for(String s : usedOnlevel){
                    set.remove(s);
                }
            }
            String word = vec.get(vec.size() - 1);
            if(word.equals(targetWord)){
                if(ans.size() == 0) ans.add(vec);
                else if(ans.get(0).size() == vec.size()) ans.add(vec);
            }
            for(int i=0;i<word.length();i++){
                for(char ch = 'a';ch <= 'z';ch++){
                    char[] replacedArray = word.toCharArray();
                    replacedArray[i] = ch;
                    String replacedWord = new String(replacedArray);
                    if(set.contains(replacedWord)){
                        vec.add(replacedWord);
                        ArrayList<String> temp = new ArrayList<>(vec);
                        q.offer(temp);
                        usedOnlevel.add(replacedWord);
                        vec.remove(vec.size() - 1);
                    }
                }
            }
        }
        return ans;
    }
}
