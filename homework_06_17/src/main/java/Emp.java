import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Emp {
    private String name;
    private int age;
    private String position;

    @Override
    public String toString() {
        return "{ n=" + name + ", a=" + age + " ,p=" + position + "}";

    }
}
