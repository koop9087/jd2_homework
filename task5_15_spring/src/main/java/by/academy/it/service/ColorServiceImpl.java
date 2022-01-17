package by.academy.it.service;

import by.academy.it.data.ColorDao;
import by.academy.it.pojo.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.NESTED)
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorDao colorDao;

    @Override
    public void saveColor(Color color) {
        this.colorDao.save(color);
    }

    @Override
    public Color getColor(Long id) {
        return colorDao.read(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public Color updateColor(Color color) {
        this.colorDao.update(color);
        return this.getColor(color.getId());
    }

    @Override
    public void deleteColor(Color color) {
        this.colorDao.delete(color);
    }

    @Override
    public List<Color> findAllColors() {
        return this.colorDao.findAll();
    }
}
