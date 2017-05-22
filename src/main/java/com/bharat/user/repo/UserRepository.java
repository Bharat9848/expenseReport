package com.bharat.user.repo;

import com.bharat.user.domain.Expense;
import com.bharat.user.domain.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * Created by BharatBh on 1/31/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Long countByLastName(String lastName);

    Long deleteByLastName(String lastName);

    @Async
    CompletableFuture<User> removeByLastName(String lastName);

    @Async
    CompletableFuture<List<User>> findByLastName(String lastName);

    @Async
    @Query("select u.expenses from User u where u.id=:userId")
    CompletableFuture<List<Expense>> findExpenses(@Param("userId")int id);

    @Async
    @EntityGraph(value="allUserDetail", type= EntityGraph.EntityGraphType.LOAD)
    @Query("select u from User u where u.id=:userId")
    CompletableFuture<User> getAllDetails(@Param("userId") int userId);
}
