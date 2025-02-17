package br.com.fiap.fiapeats.unitTests.domain.entities;

import br.com.fiap.fiapeats.domain.entities.Categoria;
import br.com.fiap.fiapeats.domain.entities.Produto;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.UUID;

 class ProdutoTest {

    @Test
     void testEqualsWithNull() {
        Produto produto1 = new Produto(null, null, null, null, null, null);
        Produto produto2 = new Produto(null, null, null, null, null, null);

        assertThat(produto1).isEqualTo(produto2);
    }

    @Test
     void testEqualsWithDifferentClass() {
        Produto produto = new Produto(UUID.randomUUID(), "Nome", "Descricao", new BigDecimal("10.00"), new Categoria(1L, "Categoria"), "http://imagem.com/img.png");
        String differentClassObject = "I am not a Produto";

        assertThat(produto).isNotEqualTo(differentClassObject);
    }

    @Test
     void testHashCodeWithNull() {
        Produto produto1 = new Produto(null, null, null, null, null, null);
        Produto produto2 = new Produto(null, null, null, null, null, null);

        assertThat(produto1).hasSameHashCodeAs(produto2);
    }

    @Test
     void testEqualsWithPartiallyNullFields() {
        UUID id = UUID.randomUUID();
        Produto produto1 = new Produto(id, "Nome", null, new BigDecimal("10.00"), null, "http://imagem.com/img.png");
        Produto produto2 = new Produto(id, "Nome", null, new BigDecimal("10.00"), null, "http://imagem.com/img.png");

        assertThat(produto1).isEqualTo(produto2);
    }

    @Test
     void testHashCodeNotEquals() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();
        Produto produto1 = new Produto(id1, "Nome", "Descricao", new BigDecimal("10.00"), new Categoria(1L, "Categoria"), "http://imagem.com/img.png");
        Produto produto2 = new Produto(id2, "Nome", "Descricao", new BigDecimal("10.00"), new Categoria(1L, "Categoria"), "http://imagem.com/img.png");

        assertThat(produto1.hashCode()).isNotEqualTo(produto2.hashCode());
    }

    @Test
    void testEquals_IgualdadeCompleta() {
        Categoria categoria = new Categoria(1L, "Categoria A");
        Produto p1 = new Produto(UUID.fromString("b6b615de-945d-486f-b47a-b8b8ff74a116"), "Produto A", "Descrição A", new BigDecimal("100.0"), categoria, "imagem.jpg");
        Produto p2 = new Produto(UUID.fromString("b6b615de-945d-486f-b47a-b8b8ff74a116"), "Produto A", "Descrição A", new BigDecimal("100.0"), categoria, "imagem.jpg");
        assertThat(p1).isEqualTo(p2);
    }

    @Test
    void testEquals_ComparandoComObjetoNulo() {
        Categoria categoria = new Categoria(1L, "Categoria A");
        Produto p1 = new Produto(UUID.randomUUID(), "Produto A", "Descrição A", new BigDecimal("100.0"), categoria, "imagem.jpg");
        assertThat(p1).isNotEqualTo(null);
    }

    @Test
    void testEquals_ComparandoComObjetoDeClasseDiferente() {
        Categoria categoria = new Categoria(1L, "Categoria A");
        Produto p1 = new Produto(UUID.randomUUID(), "Produto A", "Descrição A", new BigDecimal("100.0"), categoria, "imagem.jpg");
        String s = "Produto A";
        assertThat(p1).isNotEqualTo(s);
    }
        @Test
    void testEquals_ComparandoComObjetoConsigoMesmo() {
        Categoria categoria = new Categoria(1L, "Categoria A");
        Produto p1 = new Produto(UUID.randomUUID(), "Produto A", "Descrição A", new BigDecimal("100.0"), categoria, "imagem.jpg");
        assertThat(p1).isEqualTo(p1);
    }
}