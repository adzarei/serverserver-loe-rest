
@Data
@Entity
public class Orden{

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  private int numOrden;
  private String tituloOrden; //TODO: Queremos que sea TINYTEXT. Necesitamos @Lob?
  @Lob
  @Column(columnDefinition = "text") //21,844 carácteres ut-8 como maximo.
  private String contenido;
}
