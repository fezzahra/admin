package com.admin.Repository;

import com.admin.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity,Integer> {

   public  List<Activity> findFirst20ByOrderByIdDesc();

   public  List<Activity> findAllByTypeAction(int type_action);
}
