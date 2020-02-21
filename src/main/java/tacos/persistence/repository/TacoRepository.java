package tacos.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tacos.persistence.entity.TacoEntity;

@Repository
public interface TacoRepository extends JpaRepository<TacoEntity, Long>{

}
