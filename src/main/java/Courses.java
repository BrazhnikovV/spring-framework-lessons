import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

/**
 * Courses - класс сущность - учебный курс
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
     *  @var String name - имя
     */
    @Column( name = "name" )
    private String name;

    /**
     *  @access private
     *  @var String description - описание курса
     */
    @Column( name = "description" )
    private String description;

    /**
     *  @access private
     *  @var String created_at - время создания записи
     */
    @Column( name = "created_at" )
    private String created_at;

    /**
     *  @access private
     *  @var String updated_at - время обновления записи
     */
    @Column( name = "updated_at" )
    private String updated_at;

    /**
     *  @access private
     *  @var List<Students> studentsList - список студентов,
     *  которые посещают данный курс
     */
    @ManyToMany
    @JoinTable(
            name = "cours_studs",
            joinColumns = @JoinColumn( name = "course_id" ),
            inverseJoinColumns = @JoinColumn( name = "student_id" )
    )
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    private List<Students> studentsList;
}
