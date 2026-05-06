/*  Autor: Wellyngton Gabriel
    entidade: reserva
*/
import java.time.LocalDateTime;
import lombok.*;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "tb_reserva")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id_reserva;

    @Column(nullable = false)
    private LocalDateTime datainicio;

    @Column(nullable = false)
    private LocalDateTime datafim;

    @Column(nullable = false)
    private String statusreserva;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "clienteid", nullable = false, foreignKey = @ForeignKey(name = "clientesomething"))
    private Cliente cliente;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carroid", nullable = false, foreignKey = @ForeignKey(name = "carrosomething"))
    private Carro carro;
    
}
