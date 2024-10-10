package br.com.fiap.fiapeats.adapter.presenters;

import br.com.fiap.fiapeats.domain.entities.Pedido;
import br.com.fiap.fiapeats.usecases.dtos.CriarPedidoResponse;
import br.com.fiap.fiapeats.usecases.dtos.ListarPedidosResponse;
import br.com.fiap.fiapeats.usecases.dtos.ProdutoResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoPresenter {

  public static CriarPedidoResponse toCriarPedidoResponse(Pedido pedido) {
    return new CriarPedidoResponse(
        pedido.getId().toString(),
        pedido.getCliCpf(),
        pedido.getIdStatus(),
        pedido.getTempoEspera(),
        pedido.getDataHoraCriacao());
  }

  public static List<ListarPedidosResponse> toListarPedidosResponse(List<Pedido> pedidos) {
    List<ListarPedidosResponse> response = new ArrayList<>();

    for (Pedido pedido : pedidos) {
      response.add(
          new ListarPedidosResponse(
              pedido.getId().toString(),
              pedido.getCliCpf(),
              pedido.getIdStatus(),
              pedido.getValor(),
              pedido.getTempoEspera(),
              pedido.getDataHoraCriacao(),
              pedido.getStatusPagamento().getId(),
              pedido.getProdutos().stream().map(ProdutoResponse::new).toList()));
    }
    return response;
  }

  public static ListarPedidosResponse toListarPedidosResponse(Pedido pedido) {
    return new ListarPedidosResponse(
            pedido.getId().toString(),
            pedido.getCliCpf(),
            pedido.getIdStatus(),
            pedido.getValor(),
            pedido.getTempoEspera(),
            pedido.getDataHoraCriacao(),
            pedido.getStatusPagamento().getId(),
            pedido.getProdutos().stream().map(ProdutoResponse::new).collect(Collectors.toList())
    );
  }
}
