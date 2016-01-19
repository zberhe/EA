package cs544.hap2;

import Util.HibernateUtil;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Servlet Filter implementation class OpenSessionInViewFilter
 */
public class OpenSessionInViewFilter implements Filter {

    private SessionFactory sf;

    public void init(FilterConfig arg0) throws ServletException {
        sf = HibernateUtil.getSessionFactory();
        Transaction tx = sf.getCurrentSession().beginTransaction();
        Student student = new Student(11334, "Frank", "Brown");
        Course course1 = new Course(1101, "Java", "A");
        Course course2 = new Course(1102, "Math", "B-");
        student.addCourse(course1);
        student.addCourse(course2);
        sf.getCurrentSession().persist(student);

        tx.commit();
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        // TODO implement actual session in view fil0ter code
        Transaction tx = null;
        try {
            tx = sf.getCurrentSession().beginTransaction();
            chain.doFilter(request, response);

            tx.commit();

        } catch (RuntimeException e) {
            try {
                e.printStackTrace();
                tx.rollback();
            } catch (RuntimeException ex) {
                System.out.println("could not rollback" + ex);
                ex.printStackTrace();
            }
            throw e;
        }

        // pass the request along the filter chai
        System.out.println("receiving request");
        chain.doFilter(request, response);
        System.out.println("sending response");
    }

    public void destroy() {
    }

//	public void init(FilterConfig arg0) throws ServletException {
//	}
}
