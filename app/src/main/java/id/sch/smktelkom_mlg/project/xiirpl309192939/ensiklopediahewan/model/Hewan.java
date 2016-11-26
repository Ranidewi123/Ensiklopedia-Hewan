package id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.model;

import android.graphics.drawable.Drawable;

/**
 * Created by Rani's on 11/26/2016.
 */

public class Hewan {
    public String judul;
    public String deskripsi;
    public Drawable foto;

    public Hewan(String judul, String deskripsi, Drawable foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.foto = foto;
    }
}
