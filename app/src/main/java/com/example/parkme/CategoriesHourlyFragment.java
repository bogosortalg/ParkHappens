package com.example.parkme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CategoriesCoffeeFragment extends Fragment {
    private List<Product> products;
    private final String TAG = "CategoriesHourlyFragment";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_categories_hourly, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onStart() {
        super.onStart();
        ListView itemsList = requireActivity().findViewById(R.id.lv_categories);

        String[] names = {"1 Hour", "2 Hour", "3 Hour", "4 Hour"};
        ProductsList products = new ProductsList(names);

        CategoriesListAdapter listAdapter = new CategoriesListAdapter(requireActivity(),
                R.layout.item_categories_hourly, products.createProducts(200));
        itemsList.setAdapter(listAdapter);

        itemsList.setOnItemClickListener((parent, view, position, id) -> {
            TextView selectedFromList = (TextView) view.findViewById(R.id.tv_product_name);
            String itemText = selectedFromList.getText() + " in position " + position;

            Log.d(TAG, itemText);
            Toast.makeText(getContext(), itemText, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public static class CategoriesListAdapter extends ArrayAdapter<Product> {
        private final LayoutInflater inflater;
        private final int layout;
        private final List<Product> product;

        public CategoriesListAdapter(@NonNull Context context, int layout, List<Product> product) {
            super(context, R.layout.item_categories_hourly, product);
            this.product = product;
            this.layout = R.layout.item_categories_hourly;
            this.inflater = LayoutInflater.from(context);
        }

        @SuppressLint("SetTextI18n")
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            @SuppressLint("ViewHolder") View view=inflater.inflate(this.layout, parent, false);
            TextView productName = view.findViewById(R.id.tv_product_name);
            TextView productPrice = view.findViewById(R.id.tv_product_price);
            ImageView productImage = view.findViewById(R.id.iv_product_image);
            Product item = product.get(position);
            productName.setText(item.getName());
            productPrice.setText("$"+Integer.toString(item.getPrice())+".00");
            productImage.setImageResource(R.drawable.ic_product);
            return view;
        }
    }
}