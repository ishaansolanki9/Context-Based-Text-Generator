import java.util.Arrays;

public class Context implements Comparable<Context> {
    private String[] words;

    public Context(String[] words) {
        this.words = Arrays.copyOf(words, words.length);
    }

    public int length() {
        return words.length;
    }

    @Override
    public String toString() {
        return String.join(" ", words);
    }

    public String getWord(int index) {
        return words[index];
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Context)) return false;
        Context other = (Context) obj;
        return Arrays.equals(words, other.words);
    }

    @Override
    public int compareTo(Context other) {
        for (int i = 0; i < Math.min(words.length, other.words.length); i++) {
            int cmp = words[i].compareTo(other.words[i]);
            if (cmp != 0) return cmp;
        }
        return Integer.compare(words.length, other.words.length);
    }
}
