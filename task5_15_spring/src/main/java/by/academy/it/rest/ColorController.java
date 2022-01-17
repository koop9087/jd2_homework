package by.academy.it.rest;

import by.academy.it.pojo.Color;
import by.academy.it.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ColorController {
    @Autowired
    ColorService colorService;

    @GetMapping("/colors/{id}")
    public ResponseEntity<Color> getPerson(@PathVariable("id") Long id) {
        Color color = colorService.getColor(id);
        if (color == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(color, HttpStatus.OK);
    }

    @GetMapping("/colors")
    public ResponseEntity<List<Color>> getAllColors() {
        List<Color> colors = colorService.findAllColors();
        if (colors.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(colors, HttpStatus.OK);
    }

    @PostMapping("/colors")
    public ResponseEntity<Color> createNewColor(@RequestBody Color color) {
        if (color == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        colorService.saveColor(color);
        Color loadedColor = colorService.getColor(color.getId());
        if (loadedColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(loadedColor, HttpStatus.CREATED);
    }

    @PutMapping("/colors/{id}")
    public ResponseEntity<Color> updateColor(
            @PathVariable("id") Long id,
            @RequestBody Color color) {
        if (color == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Color loadedColor = colorService.getColor(id);
        if (loadedColor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        loadedColor = colorService.updateColor(color);
        return new ResponseEntity<>(loadedColor, HttpStatus.OK);
    }

    @DeleteMapping("/colors/{id}")
    public ResponseEntity<Color> deleteColor(@PathVariable("id") Long id) {
        Color color = colorService.getColor(id);
        colorService.deleteColor(color);
        try {
            colorService.getColor(id);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
