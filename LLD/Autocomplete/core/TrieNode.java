package core;
import java.util.*;

public class TrieNode{
    private final HashMap<Character,TrieNode> children = new HashMap<>();
    private int frequency;
    private boolean isEndOfWord;

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public int getFrequency() {
        return frequency;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public void incrementFrequency() {
        frequency++;
    }

}