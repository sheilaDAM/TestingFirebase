package com.sheilajnieto.testingfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        Category category2 = new Category("Frutas y verduras", "image2");
        Product product2 = new Product("Zanahoria", "imagecarrot", 2.50, category2);

        Category category1 = new Category("Bebidas vegetales", "image1");
        Product product1 = new Product("Yogur líquido", "imageyogur", 3, category1);

        db.collection("products").add(product2)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(MainActivity.class.getSimpleName(), "Document added with ID: " + documentReference.getId());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.d(MainActivity.class.getSimpleName(), "Error adding product.: ");
                        Log.d(MainActivity.class.getSimpleName(), e.getMessage());
                    }

                });

        db.collection("products")
                .whereEqualTo("productName", "Zanahoria")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(MainActivity.class.getSimpleName(), document.getData().toString());
                            }
                        }
                    }
                });


/*
        db.collection("products")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                // Product p = document.toObject(Product.class);
                                //Log.d(MainActivity.class.getSimpleName(), p.toString());
                                //Log.d(MainActivity.class.getSimpleName(), document.getId() + " => " + document.getData().toString());

                                Map<String, Object> map = document.getData();
                                String name = (String) map.get("productName");
                                String image = (String) map.get("image");
                                //Double productPrice = (Double) map.get("price");
                                Map<String, Object> mapCategory = (Map<String, Object>) map.get("category");
                                String categoryName = (String) mapCategory.get("categoryName");
                                String categoryImage = (String) mapCategory.get("categoryImage");
                                Category category = new Category(categoryName, categoryImage);
                                Product p = new Product(name, image, category);

                                //Log.d(MainActivity.class.getSimpleName(), map.keySet().toString());
                                Log.d(MainActivity.class.getSimpleName(), p.toString());
                                Log.d(MainActivity.class.getSimpleName(), mapCategory.toString());
                                Log.d(MainActivity.class.getSimpleName(), document.getData().toString());
                            }
                        } else {
                            Log.e(MainActivity.class.getSimpleName(), "Error getting documents (products): ", task.getException());
                        }

                    }
                });

 */
    }
}