package cs544.hap2;

import Util.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDAO {

    //private Collection<Student> studentlist = new ArrayList<Student>();
    private static SessionFactory sf = HibernateUtil.getSessionFactory();

//     public StudentDAO() {
//    static {
//       
//    }
    // }

    public Student load(long studentid) {
        return (Student) sf.getCurrentSession().get(Student.class, studentid);

    }

}
