package org.dedira.calculadora;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;

public class BancoDeDados {

    private final FirebaseFirestore db;


    public BancoDeDados() {
        db = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings.Builder fabricaDeConfiguracao =
                new FirebaseFirestoreSettings.Builder(
                        db.getFirestoreSettings()
                );

        FirebaseFirestoreSettings settings = fabricaDeConfiguracao.build();
        db.setFirestoreSettings(settings);
    }

    public void carregarExpressoes(IContratoExpressoesCarregadas c) {

        db.collection("expressoes").get().addOnCompleteListener(
                tarefa -> {
                    if (tarefa.isSuccessful()) {
                        ArrayList<Expressao> expressoes = new ArrayList<>();

                        for (QueryDocumentSnapshot documento : tarefa.getResult()) {
                            Expressao e = documento.toObject(Expressao.class);
                            e.id = documento.getId();
                            expressoes.add(e);
                        }
                        c.dadosCarregados(expressoes);
                    }
                }
        );


    }


}
