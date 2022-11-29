package com.example.kt3_dothihongkhanh;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<vidu> File_List;
    public Adapter(Context context, int layout, List<vidu>file_List){
        this.context=context;
        this.layout=layout;
        this.File_List =file_List;
    }
    @Override
    public int getCount() {
        return File_List.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=inflater.inflate(layout,null);
        TextView txtB = (TextView) view.findViewById(R.id.B);
        vidu file= File_List.get(i);
        txtB.setText(file.getVidu());
        return view;
    }
}

