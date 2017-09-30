package nuy.corp.springbootdemo.rest;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import nuy.corp.springbootdemo.jpa.entity.Song;

@Controller
public class SongController {

	@RequestMapping("/songs")
	public @ResponseBody List<Song> song(@RequestParam(value = "year") int year) {
		return Lists.newArrayList(createWith("song1", year), createWith("song5", year));
	}

	private Song createWith(String title, int year) {
		Song s = new Song();
		s.setTitle(title);
		s.setYearReleased(year);
		return s;
	}

}
