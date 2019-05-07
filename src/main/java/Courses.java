import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

/**
 * Courses - класс
 *
 * @version 1.0.1
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2018, Vasya Brazhnikov
 */
@Getter
@Setter
@Entity
@Table( name = "courses" )
public class Courses {

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
}
