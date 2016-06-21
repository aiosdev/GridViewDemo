package demo.gridviewdemo;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<String>();

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        assert gridView != null;

        String [] pic = null;
        AssetManager assetManager = getApplicationContext().getAssets();
        try {
            pic = assetManager.list("image");
            System.out.println("--------length----------"+pic.length);

            for(int i=0;i<pic.length;i++){
                System.out.println("--------picName----------"+pic[i]);
                list.add(pic[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, list);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!listPAth"+ list);
        gridView.setAdapter(gridViewAdapter);
    }
}
