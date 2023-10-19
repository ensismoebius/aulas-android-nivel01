package org.dedira.calculadora;

import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class BancoDeDados {

    private final FirebaseFirestore db;


    public BancoDeDados(){
        db = FirebaseFirestore.getInstance();

        FirebaseFirestoreSettings.Builder fabricaDeConfiguracao =
                new FirebaseFirestoreSettings.Builder(
                        db.getFirestoreSettings()
                );

        FirebaseFirestoreSettings settings = fabricaDeConfiguracao.build();
        db.setFirestoreSettings(settings);
    }




}
