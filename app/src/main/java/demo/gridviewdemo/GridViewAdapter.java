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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by guoecho on 2016/6/17.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;
    LayoutInflater layoutInflater;

    View view;


    public GridViewAdapter (Context context, List<String> list){
        this.context = context;
        this.list = list;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);




        /*
        for(int i=0; i< pic.length; i++){
            InputStream is = null;
            try {
                is = context.getAssets().open("image/"+ pic[i]);
                System.out.println("###############图片名字找到"+ pic[i]);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                System.out.println("==================bitmap找到了"+ bitmap);
                ImageView imageView = (ImageView) view.findViewById(R.id.image_view_item);
                System.out.println("~~~~~~~~~~~~~~~~~~imageview找到"+ imageView);
                imageView.setImageBitmap(bitmap);

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        list = (ArrayList<String>) Arrays.asList(pic);
        System.out.println("######@@@@@@@@@@@@list是" + list);
        */
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            view = layoutInflater.inflate(R.layout.grid_item, null);
        }else{
            view = convertView;
        }
        AssetManager assetManager = context.getAssets();

        try{
            String dirPath = "image";
            String picName = null;
            //String [] pic = assetManager.list(dirPath);
                picName = list.get(position);
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
        catch (IOException e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}



