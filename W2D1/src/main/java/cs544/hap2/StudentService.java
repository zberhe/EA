package cs544.hap2;

import Util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

    private StudentDAO studentdao;
    private static SessionFactory sf= HibernateUtil.getSessionFactory();

    public StudentService() {
        studentdao = new StudentDAO();
        //studentdao.create();
    }
    public Student getStudent(long studentid) {
//     /
        Student stud = studentdao.load(studentid);
//        Hibernate.initialize(stud.getCourselist());
//        tx.commit();
        return stud;
    }
}
