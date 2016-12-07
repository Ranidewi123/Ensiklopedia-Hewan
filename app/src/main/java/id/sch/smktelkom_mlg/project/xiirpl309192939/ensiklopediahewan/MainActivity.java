package id.sch.smktelkom_mlg.project.xiirpl309192939.ensiklopediahewan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
//Button bHer, bKar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonHerbivora).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, HerbActivity.class));
            }
        });

        findViewById(R.id.buttonKarnivora).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, KarActivity.class));
            }
        });

        findViewById(R.id.buttonInsectivora).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsecActivity.class));
            }
        });

        findViewById(R.id.buttonOmnivora).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OmnActivity.class));
            }
        });

    }
}
