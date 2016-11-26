package id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.adapter.HewanAdapter;
import id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan.model.Hewan;

public class HerbActivity extends AppCompatActivity {
    private ArrayList<Hewan> mList = new ArrayList<>();
    private HewanAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_herb);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new HewanAdapter(mList);
        recyclerView.setAdapter(mAdapter);

        fillData();
    }

    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.hewanherb);
        String[] arDeskripsi = resources.getStringArray(R.array.hewanherb_desc);
        TypedArray a = resources.obtainTypedArray(R.array.hewanherb_picture);
        Drawable[] arFoto = new Drawable[a.length()];

        for (int i = 0; i < arFoto.length; i++) {
            arFoto[i] = a.getDrawable(i);
            //BitmapDrawable bd = (BitmapDrawable) a.getDrawable(i);
            //RoundedBitmapDrawable rbd =
            //      RoundedBitmapDrawableFactory.create(getResources(), bd.getBitmap());
            //rbd.setCircular(true);
            //arFoto[i] = rbd;
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new Hewan(arJudul[i], arDeskripsi[i], arFoto[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

}
