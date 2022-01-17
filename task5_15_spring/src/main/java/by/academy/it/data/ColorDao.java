package by.academy.it.data;

import by.academy.it.pojo.Color;

import java.util.List;
import java.util.Optional;

public interface ColorDao {
    void save(Color color);

    Optional<Color> read(Long id);

    void update(Color color);

    void delete(Color color);

    List<Color> findAll();
}
