package io.wintry.finance;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface UserRepository extends MongoRepository<Users, String> {

  Users findFirstByName(String name);

  @Query("{address:'?0'}")
  List<Users> findCustomByAddress(String address);

  @Query("{address : { $regex: ?0 } }")
  List<Users> findCustomByRegExAddress(String domain);
}
