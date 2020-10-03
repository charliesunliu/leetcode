class WordDictionary {
    class TrieNode{
        public TrieNode[] childrens;
        public boolean end;
        public TrieNode(){
            childrens = new TrieNode[26];
            end = false;
        }
    }
    /** Initialize your data structure here. */

    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (currentNode.childrens[c - 'a'] == null){
                currentNode.childrens[c - 'a'] = new TrieNode();
            }
            currentNode = currentNode.childrens[c - 'a'];
        }
        currentNode.end = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode currentNode = root;
        return searchHelper(word, 0, root);
    }
    private boolean searchHelper(String word, int index, TrieNode root){
        if (root == null){
            return false;
        }
        if (index == word.length()){
            return root.end;
        }
        if (word.charAt(index) == '.'){
            for (int i = 0; i < 26; i++){
                if (searchHelper(word, index + 1, root.childrens[i])){
                    return true;
                }
                return false;
            }
        }
        else if (root.childrens[word.charAt(index) - 'a'] == null){
            return false;
        }
        return searchHelper(word, index + 1, root.childrens[word.charAt(index) - 'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */