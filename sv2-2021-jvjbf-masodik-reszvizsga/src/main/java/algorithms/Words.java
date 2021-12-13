package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWord(String word) {
        if (word.contains(" ")) {
            throw new IllegalArgumentException("It should be one word!");
        }
        if (!word.toLowerCase().equals(word)) {
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);
    }

    public boolean isThereAWordTwice() {
        List<String> list = new ArrayList<>();
        for (String actual : words) {
            if (list.contains(actual)) {
                return true;
            } else {
                list.add(actual);
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}
