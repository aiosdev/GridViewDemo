package demo.gridviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<String> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        assert gridView != null;
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, null);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!listPAth"+ list);
        gridView.setAdapter(gridViewAdapter);
    }
}
