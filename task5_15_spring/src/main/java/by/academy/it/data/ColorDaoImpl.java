package by.academy.it.data;

import by.academy.it.pojo.Color;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ColorDaoImpl implements ColorDao {
    public static final String ERROR_READ_MESSAGE = "Can't read this object because it's don't exist";

    @Autowired
    @Qualifier("customSessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public void save(Color color) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(color);
    }

    @Override
    public Optional<Color> read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Optional<Color> colorOptional;
        Color color = session.get(Color.class, id);
        if (color != null) {
            colorOptional = Optional.of(color);
        } else {
            throw new RuntimeException(ERROR_READ_MESSAGE);
        }
        return colorOptional;
    }

    @Override
    public void update(Color color) {
        Session session = sessionFactory.getCurrentSession();
        session.update(color);
    }

    @Override
    public void delete(Color color) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(color);
    }

    @Override
    public List<Color> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Color", Color.class).list();
    }
}
