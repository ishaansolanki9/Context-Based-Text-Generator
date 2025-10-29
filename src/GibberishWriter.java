import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class GibberishWriter implements Iterator<String> {
    private ArrayList<ContextData> contextDataList;
    private int contextSize;
    private Context lastContext;

    public GibberishWriter(int contextSize) {
        this.contextSize = contextSize;
        this.contextDataList = new ArrayList<>();
    }

    public int getContextSize() {
        return contextSize;
    }

    public ContextData getContextData(int index) {
        return contextDataList.get(index);
    }

    public void addDataFile(String fileName) throws FileNotFoundException {
        LinkedList<ContextData> contextDataLinkedList = new LinkedList<>();
        Scanner scanner = new Scanner(new File(fileName));
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", ""));
        }
        scanner.close();

        String[] currentContext = new String[contextSize];
        for (int i = 0; i < contextSize; i++) {
            currentContext[i] = words.get(i);
        }

        for (int i = contextSize; i < words.size(); i++) {
            Context context = new Context(currentContext);
            ContextData contextData = addContextData(context, contextDataLinkedList);
            contextData.addFollowingWord(words.get(i));
            System.arraycopy(currentContext, 1, currentContext, 0, contextSize - 1);
            currentContext[contextSize - 1] = words.get(i);
        }

        this.contextDataList = new ArrayList<>(contextDataLinkedList);
    }

    public static ContextData addContextData(Context context, LinkedList<ContextData> list) {
        for (ContextData contextData : list) {
            if (contextData.getContext().equals(context)) {
                return contextData;
            }
        }
        ContextData newContextData = new ContextData(context);
        list.add(newContextData);
        return newContextData;
    }

    @Override
    public boolean hasNext() {
        return !contextDataList.isEmpty();
    }

    @Override
    public String next() {
        if (lastContext == null) {
            lastContext = contextDataList.get(new Random().nextInt(contextDataList.size())).getContext();
        }
        ContextData contextData = addContextData(lastContext, new LinkedList<>(contextDataList));
        int randomValue = new Random().nextInt(contextData.numOccurrences()) + 1;
        String nextWord = contextData.getFollowingWord(randomValue);

        String[] updatedWords = Arrays.copyOfRange(lastContext.toString().split(" "), 1, contextSize);
        updatedWords[contextSize - 1] = nextWord;
        lastContext = new Context(updatedWords);

        return nextWord;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java GibberishWriter <file> <contextSize> <numWords>");
            return;
        }

        try {
            GibberishWriter writer = new GibberishWriter(Integer.parseInt(args[1]));
            writer.addDataFile(args[0]);

            for (int i = 0; i < Integer.parseInt(args[2]); i++) {
                System.out.print(writer.next() + " ");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
