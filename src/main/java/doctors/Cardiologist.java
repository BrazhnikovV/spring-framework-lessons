package doctors;

import interfaces.IDoctor;

/**
 * Cardiologist - класс определяющий функционал врача кардиолога
 *
 * @version 1.0.0
 * @package doctors
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Cardiologist implements IDoctor {

    @Override
    public void toTreat() {
        System.out.println( "Лечение назначено кардиологом" );
    }
}
