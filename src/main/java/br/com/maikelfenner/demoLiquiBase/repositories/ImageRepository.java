package br.com.maikelfenner.demoLiquiBase.repositories;

import br.com.maikelfenner.demoLiquiBase.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
