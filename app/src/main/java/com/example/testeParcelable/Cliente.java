package com.example.testeParcelable;

import android.graphics.Bitmap;

/**
 * Created by C047437 on 27/10/2015.
 */
public class Cliente {
    int ID;
    String nome;
    Bitmap foto;

    public Cliente() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getnome() {
        return nome;
    }

    public void setNome(String nome) {
        nome = nome;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + ID +
                ", Nome='" + nome + '\'' +
                ", foto=" + foto +
                '}';
    }
}
