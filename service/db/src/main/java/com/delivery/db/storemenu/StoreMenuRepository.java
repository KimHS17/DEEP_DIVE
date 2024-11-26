package com.delivery.db.storemenu;

import com.delivery.db.storemenu.enums.StoreMenuStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StoreMenuRepository extends JpaRepository<StoreMenuEntity, Long> {
    // 유효한 단일 메뉴 체크
    Optional<StoreMenuEntity> findByIdAndStatusOrderByIdDesc(Long id, StoreMenuStatus status);

    // 특정 가게 메뉴 가져오기
    List<StoreMenuEntity> findAllByStoreIdAndStatusOrderBySequenceDesc(Long storeId, StoreMenuStatus status);
}