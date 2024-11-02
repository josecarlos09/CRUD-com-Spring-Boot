package com.food.food.service;

import com.food.food.dto.pagamento.CadastroPagamentoDto;
import com.food.food.model.pagamento.Pagamento;
import com.food.food.model.pagamento.Status;
import com.food.food.repository.PagamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    protected ModelMapper modelMapper; // para que o ModelMapper seja injetado foi realizado uma configuração

    public Page<CadastroPagamentoDto> paginarTodosPagamentos(Pageable paginacao) {
        //Convertendo DTO em Model
        return pagamentoRepository
                .findAll(paginacao)
                .map(p->  modelMapper.map(p, CadastroPagamentoDto.class));
    }

    public CadastroPagamentoDto consultaPorId(UUID id) {
        Pagamento pagamento = pagamentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());

        return modelMapper.map(pagamento, CadastroPagamentoDto.class);
    }

    public CadastroPagamentoDto criarPagamento(CadastroPagamentoDto dto) {

        Pagamento pagamento = modelMapper.map(dto, Pagamento.class); // Convenção
        pagamento.setStatus(Status.CRIADO); // O Status vai receber pago, e as outras informações viram no corpo da requisição
        pagamentoRepository.save(pagamento);

        return modelMapper.map(pagamento, CadastroPagamentoDto.class);
    }

    public CadastroPagamentoDto atualizarPagamento(UUID id, CadastroPagamentoDto dto) {

        Pagamento pagamento = modelMapper.map(dto, Pagamento.class);
        pagamento.setId(id);
        pagamento = pagamentoRepository.save(pagamento);
        return modelMapper.map(pagamento, CadastroPagamentoDto.class);
    }

    public void excluirPagamento(UUID id) {
        pagamentoRepository.deleteById(id);
    }
}
