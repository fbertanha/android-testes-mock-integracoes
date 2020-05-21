package br.com.alura.leilao.ui.activity;

import java.util.List;

import br.com.alura.leilao.api.retrofit.client.LeilaoWebClient;
import br.com.alura.leilao.api.retrofit.client.RespostaListener;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaLeilaoAdapter;

/**
 * Created by felipebertanha on 14/May/2020
 */
public class AtualizadorDeLeiloes {

    public void buscaLeiloes(final ListaLeilaoAdapter adapter,
                             LeilaoWebClient client,
                             final ErroCarregaLeiloesListener erroCarregaLeiloesListener) {
        client.todos(new RespostaListener<List<Leilao>>() {
            @Override
            public void sucesso(List<Leilao> leiloes) {
                adapter.atualiza(leiloes);
            }

            @Override
            public void falha(String mensagem) {
                erroCarregaLeiloesListener.erroAoCarregar(mensagem);
            }
        });
    }

    public interface ErroCarregaLeiloesListener {
        void erroAoCarregar(String mensagem);
    }
}
