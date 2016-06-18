package demo.gridviewdemo;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * Created by guoecho on 2016/6/17.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> rs;
    LayoutInflater layoutInflater;
    AssetManager assetManager = null;
    public GridViewAdapter (Context context, List<Map<String, Object>> rs){
        this.context = context;
        this.rs = rs;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        assetManager = context.getAssets();
        View view;
        if(convertView == null){
            view = layoutInflater.inflate(R.layout.activity_main, null);
        }else{
            view = convertView;
        }
        try{
            String dirPath = "image";
            String picName = null;
            String [] pic = assetManager.list(dirPath);
            for(int i=0; i< pic.length; i++){
                picName = pic[i];
                InputStream is = assetManager.open(dirPath+"/"+picName);
                System.out.println("++++++++++++++图片名字"+is);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                System.out.println("==================bitmap找到了"+ bitmap);
                ImageView imageView = (ImageView) view.findViewById(R.id.image_view_item);
                System.out.println("~~~~~~~~~~~~~~~~~~imageview找到"+ imageView);
                imageView.setImageBitmap(bitmap);
                is.close();
                System.out.println("-------------------图片名字"+ picName);

            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return rs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }



}



