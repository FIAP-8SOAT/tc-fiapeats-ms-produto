package br.com.fiap.fiapeats.unitTests.external.api.contracts.response;

import br.com.fiap.fiapeats.external.api.contracts.response.ErroResponse;
import br.com.fiap.fiapeats.external.api.exceptions.RestErrorResponse;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ErrorResponseTest {

  @Test
  void deveCriarRestErrorResponseComMensagemEListaDeErros() {
    String mensagem = "Erro de validação";
    List<String> erros = Arrays.asList("Campo obrigatório", "Formato inválido");

    RestErrorResponse response = new RestErrorResponse(mensagem, erros);

    assertThat(response.getMessage()).isEqualTo(mensagem);
    assertThat(response.getErrors()).isEqualTo(erros);
    assertThat(response.getTimestamp()).isNotZero();
  }

  @Test
  void deveCriarRestErrorResponseComMensagemESemErros() {
    String mensagem = "Erro de validação";

    RestErrorResponse response = new RestErrorResponse(mensagem, null);

    assertThat(response.getMessage()).isEqualTo(mensagem);
    assertThat(response.getErrors()).isNull();
    assertThat(response.getTimestamp()).isNotZero();
  }

  @Test
  void deveCriarRestErrorResponseComListaVaziaDeErros() {
    String mensagem = "Erro de validação";
    List<String> erros = Collections.emptyList();

    RestErrorResponse response = new RestErrorResponse(mensagem, erros);

    assertThat(response.getMessage()).isEqualTo(mensagem);
    assertThat(response.getErrors()).isEqualTo(erros);
    assertThat(response.getTimestamp()).isNotZero();
  }

    @Test
    void deveCriarErroResponseComTodosOsCampos() {
      ErroResponse erroResponse = new ErroResponse("TipoErro", "CodigoErro", "Mensagem de erro");

      assertThat(erroResponse.getTipo()).isEqualTo("TipoErro");
      assertThat(erroResponse.getCodigo()).isEqualTo("CodigoErro");
      assertThat(erroResponse.getMensagem()).isEqualTo("Mensagem de erro");
    }

    @Test
    void deveCriarErroResponseComConstrutorSemArgumentos() {
      ErroResponse erroResponse = new ErroResponse();

      assertThat(erroResponse.getTipo()).isNull();
      assertThat(erroResponse.getCodigo()).isNull();
      assertThat(erroResponse.getMensagem()).isNull();
    }

    @Test
    void deveSetarEObterCamposDeErroResponse() {
      ErroResponse erroResponse = new ErroResponse();
      erroResponse.setTipo("TipoErro");
      erroResponse.setCodigo("CodigoErro");
      erroResponse.setMensagem("Mensagem de erro");

      assertThat(erroResponse.getTipo()).isEqualTo("TipoErro");
      assertThat(erroResponse.getCodigo()).isEqualTo("CodigoErro");
      assertThat(erroResponse.getMensagem()).isEqualTo("Mensagem de erro");
    }

  @Test
  void testGettersAndSetters() {
    ErroResponse response = new ErroResponse();
    response.setTipo("Erro de Validação");
    response.setCodigo("400");
    response.setMensagem("Campo obrigatório não informado");

    assertThat(response.getTipo()).isEqualTo("Erro de Validação");
    assertThat(response.getCodigo()).isEqualTo("400");
    assertThat(response.getMensagem()).isEqualTo("Campo obrigatório não informado");
  }

  @Test
  void testEqualsAndHashCode() {
    ErroResponse response1 = ErroResponse.builder()
            .tipo("Erro de Validação")
            .codigo("400")
            .mensagem("Campo obrigatório não informado")
            .build();

    ErroResponse response2 = ErroResponse.builder()
            .tipo("Erro de Validação")
            .codigo("400")
            .mensagem("Campo obrigatório não informado")
            .build();

    assertThat(response1).isEqualTo(response2).hasSameHashCodeAs(response2);
  }

  @Test
  void testToString() {
    ErroResponse response = ErroResponse.builder()
            .tipo("Erro de Validação")
            .codigo("400")
            .mensagem("Campo obrigatório não informado")
            .build();

    String expectedToString = "ErroResponse(tipo=Erro de Validação, codigo=400, mensagem=Campo obrigatório não informado)";
    assertThat(response).hasToString(expectedToString);
  }
  }
