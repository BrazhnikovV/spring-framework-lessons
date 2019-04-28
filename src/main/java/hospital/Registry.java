package hospital;

import interfaces.IDoctor;
import doctors.Cardiologist;

/**
 * Registry - класс выполняющий инверсию управления при запросах клиентов(пациентов)
 *
 * @version 1.0.0
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
public class Registry {

    /**
     *  @access private
     *  @var IDoctor doctor - хранит информацию о назначенном для лечения враче
     */
    private IDoctor doctor;

    /**
     * getDoctor - получить врача назначенного для лечения пациента
     * @return IDoctor
     */
    public IDoctor getDoctor() {
        return this.doctor;
    }

    /**
     * setDoctor - назначить врача для лечения пациента
     * @param doctor - назначенный врач
     * @return void
     */
    public void setDoctor( IDoctor doctor ) {
        this.doctor = doctor;
    }

    /**
     * referPatientToDoctor - направить пациента к доктору
     */
    public void referPatientToDoctor() {
        System.out.println( "Пройдите пожалуйста в кабинет доктора соглассно направления!" );

        //IDoctor  doctor = new Cardiologist();

        //this.setDoctor( doctor );
        this.doctor.toTreat();
    }
}
