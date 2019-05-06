
/**
 * @class - Human
 * @classdesc - класс...
 */
public class Human {

    /**
     *  @access private
     *  @var int id - идентификатор текущего объекта
     */
    private int id;

    /**
     *  @access private
     *  @var int parrentId - идентификатор родительского объекта
     */
    private int parrentId;

    /**
     * constructor
     * @param id
     * @param parrentId
     */
    public Human( int id, int parrentId ) {
        this.id = id;
        this.parrentId = parrentId;
    }
}
