package repository;

import beans.UserProfile;
import beans.WeightTrack;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WeightTrackRepository extends CrudRepository<WeightTrack, Long> {
    List<WeightTrack> findByUser(UserProfile user);
}
