package com.is4tech.javaday;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created on 3/11/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class FilmRepositoryTests {

    @Autowired
    private FilmRepository filmRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createFilm() {
        Film f = new Film();
        f.setDirector("Francis Ford Coppola");
        f.setWriter("Mario Puzo");

        Product p = new Product();
        p.setDescription("The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.");
        p.setTitle("The godfather");
        p.setType("Film");
        p = productRepository.save(p);

        f.setProductByProductId(p);

        f = filmRepository.save(f);
        assertThat(f).isNotNull();
    }

    @Test
    public void testFindFilm() {
        Film f = new Film();
        f.setWriter("Mario Puzo");
        List<Film> list = filmRepository.findAll(Example.of(f));
        assertThat(list).hasAtLeastOneElementOfType(Film.class);
    }
}
