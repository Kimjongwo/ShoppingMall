package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.User;

public interface UserRepository extends CrudRepository<User, String> {

	

	/*
	List<Board> findByContentContaining(String searchKeyword);
	List<Board> findByTitleContainingOrContentContaining(String title, String content);
	List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
	List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);
	
	@Query("SELECT b FROM Board b " + "WHERE b.title like %:searchKeyword%  " + "ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest1(@Param("searchKeyword") String searchKeyword);
	@Query("SELECT b.seq, b.title, b.writer, b.createDate " + "FROM Board b " + "WHERE b.title like %?1% "
			+ "ORDER BY b.seq DESC")
	List<Object[]> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);
	@Query(value = "select seq, title, writer, createdate " + "from board where title like '%'||?1||'%' "
			+ "order by seq desc", nativeQuery = true)
	List<Object[]> queryAnnotationTest3(String searchKeyword);
	@Query("SELECT b FROM Board b ORDER BY b.seq DESC")
	List<Board> queryAnnotationTest4(Pageable paging);
	*/
}
