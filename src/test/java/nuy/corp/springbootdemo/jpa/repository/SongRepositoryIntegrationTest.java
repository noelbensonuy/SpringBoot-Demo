package nuy.corp.springbootdemo.jpa.repository;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import nuy.corp.springbootdemo.jpa.BeanConfiguration;
import nuy.corp.springbootdemo.jpa.ConfigForTestContext;
import nuy.corp.springbootdemo.jpa.entity.Song;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { BeanConfiguration.class, ConfigForTestContext.class })
@TestPropertySource(locations = "classpath:application.test.properties")
@EnableAutoConfiguration
public class SongRepositoryIntegrationTest {

	@Resource
	SongRepository songRepository;

	List<Song> results;
	Song song1, song2, song3, song4;

	@Before
	public void setup() {
		song1 = createWith("Song1", 1987);
		song2 = createWith("Song2", 2003);
		song3 = createWith("Song3", 1987);
		song4 = createWith("Song4", 2017);
		songRepository.save(Lists.newArrayList(song1, song2, song3, song4));
	}

	@Test
	public void findByYearReleased() {
		results = songRepository.findByYearReleased(2003);

		assertResults(results, Lists.newArrayList(song2));
	}

	private void assertResults(List<Song> actual, List<Song> expected) {
		assertThat(actual.size(), equalTo(expected.size()));
		for (int i = 0; i < expected.size(); i++) {
			assertSong(actual.get(0), expected.get(0));
		}
	}

	private void assertSong(Song actual, Song expected) {
		assertThat(actual.getTitle(), equalTo(expected.getTitle()));
	}

	private Song createWith(String title, int yearReleased) {
		Song s = new Song();
		s.setTitle(title);
		s.setYearReleased(yearReleased);
		return s;
	}

}
