class TrieProgram {

	private final TrieNode root;
	public TrieProgram() {
	    root = new TrieNode();
	}

	public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        //mark the current nodes endOfWord as true
        current.endOfWord = true;
    } 

	// public void searchWord(String word) {

	// }

	// public void searchSuffix(String word) {

	// }

	// public void deleteWord(String word) {

	// }

	// public static void main() {
		
	// }

    public static void main(String args[]) {
    	TrieProgram tp = new TrieProgram();
    	tp.insert("karan");
	    	// tp.insert("paradox");

    }

}