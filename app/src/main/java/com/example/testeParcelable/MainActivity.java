package com.example.testeParcelable;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // View
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        // Resource em Bitmap
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        // Meu objeto parcelable
        final Aluno aluno = new Aluno();
        aluno.setNome("Rodrigo");
        aluno.setSobrenome("Eggea");
        aluno.setBitmap(bitmap);

        // Muda imagem desta activity
        imageView.setImageBitmap(bitmap);

        // Listener
        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

                // Enviando parcelable
                intent.putExtra("parcelable",aluno);

                startActivity(intent);
            }
        });
    }


}
