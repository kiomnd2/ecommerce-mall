package kr.ziz.ecommercemall.domain.manager;

public interface ManagerReader {

  Manager getManager(Long id);

  Manager getManager(String managerId);
}
