package doctors;

import interfaces.IDoctor;

/**
 * Therapist - класс определяющий функционал врача терапевта
 *
 * @version 1.0.0
 * @package doctors
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Therapist implements IDoctor {

    @Override
    public void toTreat() {
        System.out.println( "Лечение назначено терапевтом" );
    }
}
