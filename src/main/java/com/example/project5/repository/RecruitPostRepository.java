package com.example.project5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.project5.domain.RecruitPost;

public interface RecruitPostRepository extends JpaRepository<RecruitPost, Integer> {

	List<RecruitPost> findByOrderByIdDesc();
	
	List<RecruitPost> findByAuthorOrderByIdDesc(String author);

	// 제목검색
	@Query(
		"select r from RECRUITPOSTS r where lower(r.title) like lower('%' || :title || '%') order by r.id desc"
			)
	List<RecruitPost> searchByTitle(@Param(value="title") String title);
		
	// 내용검색
	@Query(
		"select r from RECRUITPOSTS r where lower(r.content) like lower('%' || :content || '%') order by r.id desc"
			)
	List<RecruitPost> searchByContent(@Param(value="content") String content);

	// 작성자 검색
	@Query(
		"select r from RECRUITPOSTS r where lower(r.author) like lower('%' || :author || '%') order by r.id desc"
			)
	List<RecruitPost> searchByAuthor(@Param(value="author") String author);

	// 제목, 내용검색
    @Query(
        "select r from RECRUITPOSTS r where lower(r.title) like lower('%' || :keyword || '%') "
            + " or lower(r.content) like lower('%' || :keyword || '%') order by r.id desc"
            )
    List<RecruitPost> searchByKeyword(@Param(value = "keyword") String keyword);
    
    // joinmember 구하는거 연습했던 코드... 선생님이 해보라고 하신 방법인데 다른 방법을 찾음. 그래도 나중에 공부가 될까봐서 남겨놓음
    
//    @Query("select r, count(a.id) from RECRUITPOSTS r "
//            + "left join APPLY a on r.id = a.recruitPost.id " 
//            + "where r.id = :id group by r")
//    List<RecruitPost> countMember(@Param(value = "id") Integer id);
    
//select r.id, r.created_time, r.modifid_time, r.author, r.close_date, 
//    r.file_name, r.file_path, r.join_member, r.meeting_date,
//    r.place, r.post_group, r.title, r.total_member, count(a.id)
//from recruitposts r
//    left join apply a on r.id = a.recruit_post_id
//where r.id = 46
//group by r.id, r.created_time, r.modifid_time, r.author, r.close_date, 
//    r.file_name, r.file_path, r.join_member, r.meeting_date,
//    r.place, r.post_group, r.title, r.total_member;
    
    
}
