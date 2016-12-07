package id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.model;

import java.io.Serializable;

/**
 * Created by Rani's on 11/26/2016.
 */

public class Hewan implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String foto;

    public Hewan(String judul, String deskripsi, String detail, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.foto = foto;
    }
}
