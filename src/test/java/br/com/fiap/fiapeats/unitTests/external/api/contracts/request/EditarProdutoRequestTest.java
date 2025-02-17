package br.com.fiap.fiapeats.unitTests.external.api.contracts.request;

import br.com.fiap.fiapeats.external.api.contracts.request.EditarProdutoRequest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import java.math.BigDecimal;
import java.util.Set;

class EditarProdutoRequestTest {

  private final Validator validator;

  EditarProdutoRequestTest() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  @Test
  void deveValidarEditarProdutoRequestComSucesso() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("7.99"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    Set<ConstraintViolation<EditarProdutoRequest>> violations = validator.validate(request);

    assertThat(violations).isEmpty();
  }

  @Test
  void deveRetornarErroQuandoNomeForVazio() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("7.99"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    Set<ConstraintViolation<EditarProdutoRequest>> violations = validator.validate(request);

    assertThat(violations).isNotEmpty();
  }

  @Test
  void deveRetornarErroQuandoDescricaoForVazia() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("")
            .valor(new BigDecimal("7.99"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    Set<ConstraintViolation<EditarProdutoRequest>> violations = validator.validate(request);

    assertThat(violations).isNotEmpty();
  }

  @Test
  void deveRetornarErroQuandoValorForNulo() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(null)
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    Set<ConstraintViolation<EditarProdutoRequest>> violations = validator.validate(request);

    assertThat(violations).isNotEmpty();
  }

  @Test
  void deveRetornarErroQuandoValorForNegativo() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("-1.00"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    Set<ConstraintViolation<EditarProdutoRequest>> violations = validator.validate(request);

    assertThat(violations).isNotEmpty();
  }

  @Test
  void deveRetornarErroQuandoCategoriaForVazia() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("7.99"))
            .categoria("")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    Set<ConstraintViolation<EditarProdutoRequest>> violations = validator.validate(request);

    assertThat(violations).isNotEmpty();
  }

  @Test
  void deveRetornarErroQuandoImagemUrlForMuitoLonga() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("7.99"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png".repeat(10))
            .build();

    Set<ConstraintViolation<EditarProdutoRequest>> violations = validator.validate(request);

    assertThat(violations).isNotEmpty();
  }

  @Test
  void testGettersAndSetters() {
    EditarProdutoRequest request = new EditarProdutoRequest();
    request.setNome("Refrigerante Guaraná");
    request.setDescricao("Refrigerante lata 350ml");
    request.setValor(new BigDecimal("7.99"));
    request.setCategoria("Bebida");
    request.setImagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png");

    assertThat(request.getNome()).isEqualTo("Refrigerante Guaraná");
    assertThat(request.getDescricao()).isEqualTo("Refrigerante lata 350ml");
    assertThat(request.getValor()).isEqualTo(new BigDecimal("7.99"));
    assertThat(request.getCategoria()).isEqualTo("Bebida");
    assertThat(request.getImagemUrl()).isEqualTo("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png");
  }

  @Test
  void testEqualsAndHashCode() {
    EditarProdutoRequest request1 = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("7.99"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    EditarProdutoRequest request2 = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("7.99"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    assertThat(request1).isEqualTo(request2).hasSameHashCodeAs(request2);
  }

  @Test
  void testToString() {
    EditarProdutoRequest request = EditarProdutoRequest.builder()
            .nome("Refrigerante Guaraná")
            .descricao("Refrigerante lata 350ml")
            .valor(new BigDecimal("7.99"))
            .categoria("Bebida")
            .imagemUrl("https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png")
            .build();

    String expectedToString = "EditarProdutoRequest(nome=Refrigerante Guaraná, descricao=Refrigerante lata 350ml, valor=7.99, categoria=Bebida, imagemUrl=https://dcdn.mitiendanube.com/stores/001/043/122/products/guarana-350-ml1-36b27837866444073815698470135434-640-0.png)";
    assertThat(request).hasToString(expectedToString);
  }
}