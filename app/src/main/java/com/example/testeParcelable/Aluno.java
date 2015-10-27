package com.example.testeParcelable;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

// Referencia:
// http://android-er.blogspot.com.br/2013/03/example-to-implement-parcelable.html
// http://www.3pillarglobal.com/insights/parcelable-vs-java-serialization-in-android-app-development

public class Aluno implements Parcelable {
    private String nome;
    private String sobrenome;
    private Bitmap bitmap;

    // Construtor padrão
    public Aluno() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) { this.nome = nome;  }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Bitmap getBitmap() { return bitmap;  }

    public void setBitmap(Bitmap bitmap) { this.bitmap = bitmap;  }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", bitmap=" + bitmap +
                '}';
    }

    // --------------------------- PARCELABLE -----------------------------------------
    // Construtor com Parcelable
    // Customizar como os dados serão reconstruídos no objeto (empacotado)
    // Colocar na sequência correta de empacotamento
    public Aluno(Parcel parcel) {
        this.nome = parcel.readString();
        this.sobrenome = parcel.readString();
        this.bitmap = parcel.readParcelable(null);
    }

    // Method to recreate a Catch from a Parcel
    // Método padrão não precisa mudar nada
    // Só mudar o nome da classe
    public static Creator<Aluno> CREATOR = new Creator<Aluno>() {
        @Override
        public Aluno createFromParcel(Parcel source) {
            return new Aluno(source);
        }

        @Override
        public Aluno[] newArray(int size) {
            return new Aluno[size];
        }
    };

    // Pode deixar vazio - Método padrão
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    // Customizar como será serializado (desempacotado)
    // Colocar os dados na sequência correta de desempacotamento
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(sobrenome);
        dest.writeParcelable(bitmap, flags);
    }

    // ----------------------------------------------------------------------------------
}
