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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by guoecho on 2016/6/17.
 */
public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<Map<String, Object>> picList;
    int layoutResourceId;
    LayoutInflater layoutInflater;
    AssetManager assetManager = null;
    public GridViewAdapter (Context context, int layoutResourceId,List<Map<String, Object>> picList){
        this.context = context;
        this.picList = picList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.layoutResourceId = layoutResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        assetManager = context.getAssets();
        View view;
        if(convertView == null){
            view = layoutInflater.inflate(R.layout.grid_item, null);
        }else{
            view = convertView;
        }
        picList = new ArrayList<>();
        String [] pic = null;
        String dirPath = "image";
        String picName = null;
        try{
            pic = assetManager.list(dirPath);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i< pic.length; i++){
            picName = pic[i];
            InputStream is = null;
            try {
                is = context.getAssets().open(dirPath+"/"+picName);
                System.out.println("++++++++++++++图片名字"+is);
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                System.out.println("==================bitmap找到了"+ bitmap);
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("name", pic[i]);
                map.put("bitmap", bitmap);
                map.put("id", i);
                picList.add(map);
                System.out.println("----------++++++++++-------map是"+ map);
                ImageView imageView = (ImageView) view.findViewById(R.id.image_view_item);
                System.out.println("~~~~~~~~~~~~~~~~~~imageview找到"+ imageView);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {

                    if(is !=null){
                        try {
                            is.close();
                        }catch (IOException e){
                            e.printStackTrace();
                        }
                    }
            }
//            System.out.println("-------------------图片名字"+ picName);
        }
        return view;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return picList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



}



