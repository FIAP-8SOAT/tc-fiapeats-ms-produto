package br.com.fiap.fiapeats.usecases.interfaces.in.pedido;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoDTO;

public interface CriarPedidoUseCase {
  Pedido criarPedido(CriarPedidoDTO criarPedidoDTO);
}
