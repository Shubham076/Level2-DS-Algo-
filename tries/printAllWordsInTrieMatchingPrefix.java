
/*
dictionary = [test, testing, testingdone, move, moving, cat, cats]
words = [tes, mov, cat]
output = [[test, testing, testingdone], [move, moving], [cat, cats]]
*/
import java.util.*;

public class printAllWordsInTrieMatchingPrefix {
    static class Trie {
        class Node {
            Node[] childs;
            String s;

            Node() {
                childs = new Node[26];
            }
        }

        Node root;

        Trie(){
            root = new Node();
        }

        public void insert(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    cur.childs[c - 'a'] = new Node();
                }
                cur = cur.childs[c - 'a'];
            }
            cur.s = s;
        }

        public void getAllWords(Node root, ArrayList<String> list) {
            if (root == null)
                return;
            if (root.s != null) {
                list.add(root.s);
            }

            for (Node c : root.childs) {
                if (c != null) {
                    getAllWords(c, list);
                }
            }
        }

        public ArrayList<String> getWords(String prefix) {
            ArrayList<String> ans = new ArrayList<>();
            Node cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (cur.childs[c - 'a'] == null) {
                    return ans;
                }
                cur = cur.childs[c - 'a'];
            }
            if (cur.s != null) {
                ans.add(cur.s);
            }
            for (Node c : cur.childs) {
                getAllWords(c, ans);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        String[] dict = { "shivani", "shubham" };
        String[] prefixes = { "sh"};
        Trie t = new Trie();
        for(String s: dict){
            t.insert(s);
        }

        for(String p: prefixes){
            ans.add(t.getWords(p));
        }

        System.out.println(ans);
    }
}
