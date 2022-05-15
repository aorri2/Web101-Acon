package com.example.demo.persistence;

import com.example.demo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity,String> {
    List<TodoEntity> findByUserId(String userId);
    /**
     이 메서드를 작성하면 스프링 데이터 JPA가 메서드 이름을 파싱해서 SELECT * FROM TodoRepository WHERE userId = '{userId}'
     와 같은 쿼리를 작성해 실행한다.

     더 복잡한 쿼리는 @Query 어노테이션을 사용해 지정할 수 있다.

     메서드 이름 작성 방법과 예제(레퍼런스)
     https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
     */
    //?1은 메서드의 매개변수의 순서 위치다.
//    @Query("select * from Todo t where t.userId =?1")
//    List<TodoEntity> findByUserId(String userId);


}
