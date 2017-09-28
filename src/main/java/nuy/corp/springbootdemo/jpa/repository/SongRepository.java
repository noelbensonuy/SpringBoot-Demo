package nuy.corp.springbootdemo.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nuy.corp.springbootdemo.jpa.entity.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

	@Query("select s from Song s where s.yearReleased = ?1")
	List<Song> findByYearReleased(int yearReleased, Pageable pageable);

}
