import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Words {
    String word;
    TreeSet<Integer> position;

    public Words(String word, TreeSet<Integer> position) {
        this.word = word;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Words words = (Words) o;
        return Objects.equals(word, words.word);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(word);
    }

    @Override
    public String toString() {
        return "" +
                "'" + word + '\'' +
                ":" + position +
                "";
    }
    // {"один":[0,2], "раз":[1,3,7], "это":[2], "но":[5], "только":[6]}
}
