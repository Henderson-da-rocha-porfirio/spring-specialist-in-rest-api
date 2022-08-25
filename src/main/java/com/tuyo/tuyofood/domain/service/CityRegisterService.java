package com.tuyo.tuyofood.domain.service;

import com.tuyo.tuyofood.domain.entity.City;
import com.tuyo.tuyofood.domain.entity.State;
import com.tuyo.tuyofood.domain.exception.EntidadeEmUsoException;
import com.tuyo.tuyofood.domain.exception.EntidadeNaoEncontradaException;
import com.tuyo.tuyofood.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CityRegisterService {

    private static final String MSG_CIDADE_NAO_ENCONTRADA = "Cidade de código %d não pode ser removida, pois está em uso";
    private static final String MSG_CIDADE_EM_USO = "Não existe um cadastro de cidade com código %d";
    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private StateRegisterService stateRegisterService;

    public City salvar(City city) {
        Long stateId = city.getState().getId();

        State state = stateRegisterService.buscarOuFalhar(stateId);

        city.setState(state);

        return cityRepository.save(city);

    }

    public void excluir(Long cityId) {
        try {
            cityRepository.deleteById(cityId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_CIDADE_NAO_ENCONTRADA, cityId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_CIDADE_EM_USO, cityId));
        }
    }

    public City buscarOuFalhar(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_CIDADE_NAO_ENCONTRADA, cityId)));
    }
}
