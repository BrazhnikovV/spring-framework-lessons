package hospital;

import doctors.Therapist;
import interfaces.IDoctor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Registry - класс выполняющий инверсию управления при запросах клиентов(пациентов)
 *
 * @version 1.0.0
 * @package hospital
 * @author  Vasya Brazhnikov
 * @copyright Copyright (c) 2019, Vasya Brazhnikov
 */
@Component
public class Registry {

    /**
     *  @access private
     *  @var IDoctor doctor - хранит информацию о назначенном для лечения враче
     */
    private IDoctor doctor = new Therapist();

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
    @Autowired( required = false )
    public void setDoctor( IDoctor doctor ) {
        this.doctor = doctor;
    }

    /**
     * referPatientToDoctor - направить пациента к доктору
     */
    public void referPatientToDoctor() {
        System.out.println( "Пройдите пожалуйста в кабинет доктора соглассно направления!" );

        this.doctor.toTreat();
    }
}
