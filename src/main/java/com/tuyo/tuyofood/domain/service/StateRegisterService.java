package com.tuyo.tuyofood.domain.service;

import com.tuyo.tuyofood.domain.entity.State;
import com.tuyo.tuyofood.domain.exception.EntidadeEmUsoException;
import com.tuyo.tuyofood.domain.exception.EntidadeNaoEncontradaException;
import com.tuyo.tuyofood.domain.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class StateRegisterService {

    private static final String MSG_ESTADO_NAO_ENCONTRADO = "Estado de código %d não pode ser removido, pois está em uso";
    private static final String MSG_ESTADO_EM_USO = "Não existe um cadastro de estado com código %d";
    @Autowired
    private StateRepository stateRepository;

    public State salvar(State state) {
        return stateRepository.save(state);
    }

    public void excluir(Long stateId) {
        try {
            stateRepository.deleteById(stateId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_ESTADO_NAO_ENCONTRADO, stateId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ESTADO_EM_USO, stateId));
        }
    }

    public State buscarOuFalhar(Long stateId) {
        return stateRepository.findById(stateId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_ESTADO_NAO_ENCONTRADO, stateId)));
    }
}
