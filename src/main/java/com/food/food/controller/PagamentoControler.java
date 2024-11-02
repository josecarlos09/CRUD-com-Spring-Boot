package com.food.food.controller;

import com.food.food.dto.pagamento.CadastroPagamentoDto;
import com.food.food.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoControler {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping("/consultar")
    public Page<CadastroPagamentoDto> consulta(@PageableDefault(size = 10) Pageable paginacao){
        return pagamentoService.paginarTodosPagamentos(paginacao);
    }

    @GetMapping("/consulta_detalhada/{id}")
    public ResponseEntity<CadastroPagamentoDto> detalhar(@PathVariable @NotNull UUID id) {
        CadastroPagamentoDto dto = pagamentoService.consultaPorId(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<CadastroPagamentoDto> cadastrar(@RequestBody @Valid CadastroPagamentoDto dto, UriComponentsBuilder uriBuilder) {
        CadastroPagamentoDto pagamento = pagamentoService.criarPagamento(dto);
        URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.getNome()).toUri();

        return ResponseEntity.created(endereco).body(pagamento);
    }

    @PutMapping("atualizar/{id}")
    public ResponseEntity<CadastroPagamentoDto> atualizar(@PathVariable @NotNull UUID id, @RequestBody @Valid CadastroPagamentoDto dto) {
        CadastroPagamentoDto atualizado = pagamentoService.atualizarPagamento(id, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("excluir/{id}")
    public ResponseEntity<CadastroPagamentoDto> remover(@PathVariable @NotNull UUID id) {
        pagamentoService.excluirPagamento(id);
        return ResponseEntity.noContent().build();
    }

}
