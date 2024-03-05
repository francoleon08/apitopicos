package com.francoleon.apitopicos.service;

import com.francoleon.apitopicos.error.DuplicateKeyException;
import com.francoleon.apitopicos.persistence.entity.Topico;

public interface ServiceTopico {

    public Topico saveTopico(Topico topico) throws DuplicateKeyException;
}
