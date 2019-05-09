import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.persistence.*;

/**
 * Students - класс
 *
 * @version 1.0.1
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@Getter
@Setter
@Entity
@Table( name = "students" )
public class Students {

    /**
     *  @access private
     *  @var int id - перавичный ключ таблицы
     */
    @Id
    @Column( name = "id" )
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;

    /**
     *  @access private
     *  @var String name -
     */
    @Column( name = "name" )
    private String name;

    /**
     *  @access private
     *  @var String description -
     */
    @Column( name = "description" )
    private String description;

    /**
     *  @access private
     *  @var String created_at -
     */
    @Column( name = "created_at" )
    private String created_at;

    /**
     *  @access private
     *  @var String updated_at -
     */
    @Column( name = "updated_at" )
    private String updated_at;


    /**
     *  @access private
     *  @var List<Dekanat> dekanatList -
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "cours_studs",
            joinColumns = @JoinColumn( name = "student_id" ),
            inverseJoinColumns = @JoinColumn( name = "course_id" )
    )
    private List<Courses> coursesList;
}
