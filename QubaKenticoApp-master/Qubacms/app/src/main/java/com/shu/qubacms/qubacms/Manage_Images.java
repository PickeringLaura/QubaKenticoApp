package com.shu.qubacms.qubacms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class Manage_Images extends AppCompatActivity {

    int[] images = {R.drawable.imageone, R.drawable.imagetwo, R.drawable.imagethree, R.drawable.imagefour};

    String [] names = {"Image 1", "Image 2", "Image 3", "Image 4"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage__images);

        mListView = (ListView) findViewById(R.id.listView);

        CustomAdaptor customAdaptor = new CustomAdaptor();
        mListView.setAdaptor(customAdaptor);
    }

    class CustomAdaptor extends BaseAdapter {


        @Override
        public int getCount() {
            return images.length;
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
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = getLayoutInflater().inflate(R.layout.customlayout, null);
            ImageView mImageView = (ImageView) view.findViewById(R.id.imageView);
            TextView = mTextView = view.findViewById(R.id.textView);

            mImageview.setImageResource(images[position]);
            mTextView.setText(Names[position]);

            return view;
        }
    }
}
