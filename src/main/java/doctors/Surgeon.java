package doctors;

import interfaces.IDoctor;

/**
 * Surgeon - класс определяющий функционал врача хирурга
 *
 * @version 1.0.0
 * @package doctors
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Surgeon implements IDoctor {

    @Override
    public void toTreat() {
        System.out.println( "Лечение назначено хирургом" );
    }
}
