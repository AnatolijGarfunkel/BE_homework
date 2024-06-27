import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Emp {
    private String name;
    private int age;
    private String position;


    @Override
    public String toString() {
        return "{ n="+name+", a="+age+" , p=" + position + " }";
    }
}
