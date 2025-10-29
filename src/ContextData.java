import java.util.LinkedList;

public class ContextData implements Comparable<ContextData> {
    private Context context;
    private int numOccurrences;
    private LinkedList<WordData> wordList;

    public ContextData(Context context) {
        this.context = context;
        this.numOccurrences = 0;
        this.wordList = new LinkedList<>();
    }

    public Context getContext() {
        return context;
    }

    public int numOccurrences() {
        return numOccurrences;
    }

    public void addFollowingWord(String word) {
        for (WordData wordData : wordList) {
            if (wordData.getWord().equals(word)) {
                wordData.incrementCount();
                numOccurrences++;
                return;
            }
        }
        wordList.add(new WordData(word));
        numOccurrences++;
    }

    public String getFollowingWord(int value) {
        int cumulativeCount = 0;
        for (WordData wordData : wordList) {
            cumulativeCount += wordData.getCount();
            if (value <= cumulativeCount) {
                return wordData.getWord();
            }
        }
        throw new IllegalArgumentException("Value out of range");
    }

    @Override
    public int compareTo(ContextData other) {
        return context.compareTo(other.context);
    }
}
