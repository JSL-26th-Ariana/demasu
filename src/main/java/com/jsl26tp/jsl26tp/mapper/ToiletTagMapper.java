package com.jsl26tp.jsl26tp.mapper;

import com.jsl26tp.jsl26tp.domain.ToiletTag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface ToiletTagMapper {

    // 화장실의 태그 목록 조회
    List<ToiletTag> findByToiletId(@Param("toiletId") Long toiletId);

    // 태그 추가
    void insertTag(ToiletTag tag);

    // 태그 삭제
    void deleteByToiletId(@Param("toiletId") Long toiletId);
}
