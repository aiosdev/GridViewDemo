package demo.gridviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private List<Map<String, Object>> picList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridView = (GridView) findViewById(R.id.grid_view);
        assert gridView != null;
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this,picList);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!listPAth"+ picList);
        gridView.setAdapter(gridViewAdapter);
    }
}
