package kr.ziz.ecommercemall.infrastructure.manager;

import kr.ziz.ecommercemall.domain.manager.Manager;
import kr.ziz.ecommercemall.domain.manager.fixture.ManagerFixture;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class ManagerRepositoryTest {

  @Autowired
  private ManagerRepository managerRepository;

  @DisplayName("운영자 등록")
  void managerRegister() {
    // given
    Manager initManager = ManagerFixture.createManager();

    // when
    Manager savedManager = managerRepository.save(initManager);

    // then
    assertThat(savedManager.getId()).isNotNull();
    assertThat(savedManager.getManagerToken()).isEqualTo(initManager.getManagerToken());
    assertThat(savedManager.getEmail()).isEqualTo(initManager.getEmail());
    assertThat(savedManager.getManagerNm()).isEqualTo(initManager.getManagerNm());
    assertThat(savedManager.getManagerPw()).isEqualTo(initManager.getManagerPw());
    assertThat(savedManager.getPhoneNo()).isEqualTo(initManager.getPhoneNo());
  }
}