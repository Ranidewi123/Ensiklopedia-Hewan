package id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
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

public class InsecActivity extends AppCompatActivity implements HewanAdapter.IHewanAdapter {
    public static final String HEWAN = "hewan";
    private ArrayList<Hewan> mList = new ArrayList<>();
    private HewanAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herb);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Insektivora");
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HewanAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.hewaninsec);
        String[] arDeskripsi = resources.getStringArray(R.array.hewaninsec_desc);
        String[] arDetail = resources.getStringArray(R.array.hewaninsec_details);
        TypedArray a = resources.obtainTypedArray(R.array.hewaninsec_picture);
        String[] arFoto = new String[a.length()];

        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);

            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Hewan(arJudul[i], arDeskripsi[i],
                    arDetail[i], arFoto[i]));
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

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(HEWAN, mList.get(pos));
        startActivity(intent);
    }

}
