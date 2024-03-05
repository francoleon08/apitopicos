package com.francoleon.apitopicos.persistence.repository;

import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.entity.TopicoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, TopicoId> {

    /**
     * Recupera un topico por su long id
     * @param id_id id del topico
     * @return Topico
     */
    public Optional<Topico> findTopicoById_Id(Long id_id);

    public void deleteTopicoById_Id(long id_id);
}
