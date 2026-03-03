package com.jsl26tp.jsl26tp.mapper;

import com.jsl26tp.jsl26tp.domain.Inquiry;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface InquiryMapper {

    // 문의 등록
    void insertInquiry(Inquiry inquiry);

    // 문의 목록 (관리자용 - 전체)
    List<Inquiry> findAllInquiries();

    // 내 문의 목록 (사용자용)
    List<Inquiry> findByWriterId(@Param("writerId") Long writerId);

    // 문의 상세 조회
    Inquiry findById(@Param("id") Long id);

    // 답변 등록 (관리자)
    void updateAnswer(@Param("id") Long id,
                      @Param("adminId") Long adminId,
                      @Param("answer") String answer);

    // 문의 삭제 (소프트 삭제)
    void deleteInquiry(@Param("id") Long id);
}
