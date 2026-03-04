package com.jsl26tp.jsl26tp.toilet.mapper;

import com.jsl26tp.jsl26tp.toilet.domain.ToiletEditRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ToiletEditRequestMapper {

    // 수정 제안 등록
    void insertRequest(ToiletEditRequest request);

    // 수정 제안 목록 (관리자용)
    List<ToiletEditRequest> findAllRequests();

    // 대기 중인 수정 제안 목록
    List<ToiletEditRequest> findPendingRequests();

    // 수정 제안 상세 조회
    ToiletEditRequest findById(@Param("id") Long id);

    // 수정 제안 상태 변경 (승인/거절)
    void updateStatus(@Param("id") Long id, @Param("status") String status);
}
