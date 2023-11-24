package vicktorms.br.infnet.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Book {
    private String title;
    private String author;
    private int pages;
}
