import java.util.HashMap;
import java.util.Map;
import java.util.Collection;
import java.util.Iterator;

public class TrieNode {
	
	Map<Character, TrieNode> children;
	boolean endOfWord;

	public TrieNode() {
		children = new HashMap<Character, TrieNode>();
		endOfWord = false;
	}

}