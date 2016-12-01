package id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.adapter.HewanAdapter;
import id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.model.Hewan;

/**
 * Created by Bek Nu on 01/12/2016.
 */

public class InsecActivity extends AppCompatActivity {
    private ArrayList<Hewan> mList = new ArrayList<>();
    private HewanAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herb);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HewanAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.hewaninsec);
        String[] arDeskripsi = resources.getStringArray(R.array.hewaninsec_desc);
        TypedArray a = resources.obtainTypedArray(R.array.hewaninsec_picture);
        Drawable[] arFoto = new Drawable[a.length()];

        for (int i = 0; i < arFoto.length; i++) {
            arFoto[i] = a.getDrawable(i);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Hewan(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}