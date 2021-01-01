package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRcvFood;
    List<Food> mArrFood;
    FoodAdapter mFoodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRcvFood = findViewById(R.id.recyclenowfood);

        //data Mock: data giả

        mArrFood = Food.getMock();
        mFoodAdapter = new FoodAdapter(mArrFood);

        mRcvFood.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        mRcvFood.setAdapter(mFoodAdapter);

        mFoodAdapter.setOnItemClickListener(new OnClickListenerItem() {
            @Override
            public void onClick(Integer position) {


                mArrFood.remove(Integer.parseInt(position + ""));
                mFoodAdapter.notifyItemRemoved(Integer.parseInt(position + ""));

                //lệnh toast vận chuyển dữ liệu từ FoodAdapter sang MainActivity thông qua Interface
               /* Toast.makeText(MainActivity.this, mArrFood.get(position).getName(), Toast.LENGTH_SHORT).show();*/
            }
        });











        //Array: dạng mảng array

        //cách 1: khởi tạo và gán giá trị
    /*    String[] arrnames = {"Teo","Ti","Tuan"};

        arrnames[0] = "Tun"; //thay đổi giá trị cho mảng
        Log.d("BBBB",arrnames[0]);*/

        //cách 2: khởi tạo kích thước
      /*  String[] arrnames2 = new String[2];
        Log.d("BBBBB",arrnames2[0] +""); */

        //Collection: Dạng mảng theo nhóm cấu trúc collection

        List<String> strings = new ArrayList<>();
        //thêm dữ liệu:
        strings.add("Teo");
        strings.add("Ti");
        //cập nhật dữ liệu:
        strings.set(0,"Tiến");//set(): hàm cập nhật

        //Xóa dữ liệu
        strings.remove(0);

        Log.d("BBBB",strings.get(0)); //strings.get(vị trí giá trị mảng) : để lấy giá trị phần tử mảng

        Log.d("BBBB",strings.size() +""); //lấy kích thước mảng


    }
}
