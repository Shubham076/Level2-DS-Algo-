import java.util.*;
// Time: O(L * n) space complexity O(m *n) m are the strings stored in the queue
//L is the length of the maximum string
class wordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set  = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);
        int level = 1;
        while (q.size() > 0) {
            int size = q.size();

            while (size-- > 0) {
                String s = q.remove();
                char[] arr = s.toCharArray();

                for (int i = 0; i < arr.length; i++) {
                    char original_char = arr[i];

                    for (char j = 'a'; j <= 'z'; j++) {
                        if (arr[i] == j) continue;
                        arr[i] = j;

                        String temp = String.valueOf(arr);
                        if (temp.equals(endWord)) return level + 1;

                        if (set.contains(temp)) {
                            q.add(temp);
                            set.remove(temp);
                        }
                    }
                    arr[i] = original_char;
                }
            }
            level++;
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> list = new ArrayList<>();
        for(String s: wordList){
            list.add(s);
        }
        System.out.println(ladderLength(beginWord, endWord, list));
    }
}