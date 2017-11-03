package com.is4tech.javaday;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
public class AudioAlbumRepositoryTests {

    @Autowired
    private AudioAlbumRepository audioAlbumRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void createAudioAlbum() {
        AudioAlbum f = new AudioAlbum();
        f.setArtist("Guns N' Roses");
        f.setGenre("Hard rock");

        Product p = new Product();
        p.setDescription("Appetite for Destruction is the debut studio album by American hard rock band Guns N' Roses. It was released on July 21, 1987, by Geffen Records to massive commercial success.");
        p.setTitle("Appetite for Destruction");
        p.setType("Album");
        p = productRepository.save(p);

        f.setProductByProductId(p);

        f = audioAlbumRepository.save(f);
        assertThat(f).isNotNull();
    }

    @Test
    public void testFindAudioAlbum() {
        AudioAlbum f = new AudioAlbum();
        f.setArtist("Guns N' Roses");
        List<AudioAlbum> list = audioAlbumRepository.findAll(Example.of(f));
        assertThat(list).hasAtLeastOneElementOfType(AudioAlbum.class);
    }
}
