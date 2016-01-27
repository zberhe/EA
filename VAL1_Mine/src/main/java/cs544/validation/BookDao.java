package cs544.validation;

import java.util.List;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
//
@Transactional
public class BookDao implements IBookDao {

   
    private SessionFactory sessionFactory;

//	private static int idCount = 1;
//	private Map<Integer, Book> books = new HashMap<>();
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Book> getAll() {
        Query q = sessionFactory.getCurrentSession().createQuery("from Book");
        return q.list();
    }

    @Override
    public void add(Book book) {
        sessionFactory.getCurrentSession().persist(book);
    }

    @Override
    public Book get(int id) {
        return (Book) sessionFactory.getCurrentSession().load(Book.class, id);
    }

    @Override

    public void update(int bookId, Book book) {
        Book b = get(bookId);
        b.setAuthor(book.getAuthor());
        b.setTitle(book.getTitle());
        b.setISBN(book.getISBN());
        b.setPrice(book.getPrice());
    }

    @Override
    public void delete(int bookId) {
        Book b = get(bookId);
        sessionFactory.getCurrentSession().delete(b);
    }
}
