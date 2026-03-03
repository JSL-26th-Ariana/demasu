package com.jsl26tp.jsl26tp.mapper;

import com.jsl26tp.jsl26tp.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ReviewMapper {

    // 화장실의 리뷰 목록 조회
    List<Review> findByToiletId(@Param("toiletId") Long toiletId);

    // 리뷰 상세 조회
    Review findById(@Param("id") Long id);

    // 리뷰 작성
    void insertReview(Review review);

    // 리뷰 수정
    void updateReview(Review review);

    // 리뷰 삭제 (소프트 삭제)
    void deleteReview(@Param("id") Long id);

    // 사용자의 리뷰 목록
    List<Review> findByUserId(@Param("userId") Long userId);

    // 화장실 평균 청결도 점수
    Double getAvgScore(@Param("toiletId") Long toiletId);

    // 화장실 리뷰 수
    Integer getReviewCount(@Param("toiletId") Long toiletId);
}
