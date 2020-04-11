package pl.mzuchnik.springpracadomowa8b.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mzuchnik.springpracadomowa8b.entity.NoteEntity;

@Repository
public interface NoteRepo extends JpaRepository<NoteEntity,Long> {
}
