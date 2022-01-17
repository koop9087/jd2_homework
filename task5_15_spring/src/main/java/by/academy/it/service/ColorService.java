package by.academy.it.service;

import by.academy.it.pojo.Color;

import java.util.List;

public interface ColorService {
    void saveColor(Color color);

    Color getColor(Long id);

    Color updateColor(Color color);

    void deleteColor(Color color);

    List<Color> findAllColors();
}
