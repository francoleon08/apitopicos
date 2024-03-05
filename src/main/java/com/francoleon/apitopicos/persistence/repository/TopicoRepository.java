package com.francoleon.apitopicos.persistence.repository;

import com.francoleon.apitopicos.persistence.entity.Topico;
import com.francoleon.apitopicos.persistence.entity.TopicoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicoRepository extends JpaRepository<Topico, TopicoId> {
}
