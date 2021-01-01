package com.example.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {


    //Constructor: phương thức khởi tạo

    List<Food> mArrFood;
    String mcategory = "";
    OnClickListenerItem mOnClickListenerItem;

    public FoodAdapter(List<Food> mArrFood) {
        this.mArrFood = mArrFood;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutinflater = LayoutInflater.from(parent.getContext());
        //inflate : giúp cho việc thực hiện chuyển đổi kiểu dữ liệu
        View view = layoutinflater.inflate(R.layout.layout_item_nowfood,parent,false);
        //attachtoRoot : True : là khi muốn chuyển kiểu dữ liệu của tất cả thằng con trong layout.xml sang kiểu view
        ////attachtoRoot : false : là khi chỉ muốn chuyển kiểu dữ liệu của thằng cha layout.xml sang kiểu view còn thằng con giữ nguyên
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        mcategory ="";

        Food food = mArrFood.get(position);
        if(food.getStatus()){
            holder.status.setImageResource(R.drawable.ic_online);
        }
        else
        {
            holder.status.setImageResource(R.drawable.ic_offline);
        }
        holder.foodchaosuon.setImageResource(food.getImage());
        holder.txttenmon.setText(food.getName());

        if(food.getArrrayAddress().length > 1)
        {
            holder.txtaddress.setVisibility(View.VISIBLE);
            holder.txtdetailaddress.setVisibility(View.GONE);
            holder.txtaddress.setText(food.getArrrayAddress().length + " địa điểm");

        }
        else{
            holder.txtdetailaddress.setVisibility(View.VISIBLE);
            holder.txtaddress.setVisibility(View.GONE);
            holder.txtdetailaddress.setText(food.getArrrayAddress()[0]);
        }
        holder.txtminprice.setText("tối thiểu " + food.getMinprice() + "k");
        holder.txtmaxprice.setText("Giá " + food.getPrice() + "k");

        if(!food.getSaleoff().isEmpty()){

            holder.linearSaleoff.setVisibility(View.VISIBLE);
            holder.txtcategory.setVisibility(View.GONE);
            holder.txtsaleoff.setText(food.getSaleoff());
        }
        else
        {
            holder.txtcategory.setVisibility(View.VISIBLE);
            holder.linearSaleoff.setVisibility(View.GONE);

            for(int i=0; i<food.getCategory().length ;i++)
            {
                mcategory += food.getCategory()[i] + ", ";
            }
            mcategory = mcategory.substring(0, mcategory.length() -2);
            holder.txtcategory.setText(mcategory);
        }




    }

    @Override
    public int getItemCount() {

        if(mArrFood == null){
            return 0;
        }
        else{
            return mArrFood.size();
        }

    }




    class FoodViewHolder extends RecyclerView.ViewHolder {

        ImageView foodchaosuon, status,imgminprice,imgmaxprice,imgsaleoff;
        TextView txttenmon,txtaddress,txtdetailaddress,txtminprice,txtmaxprice,txtsaleoff,txtcategory;
        LinearLayout linearcontainer_category,linearSaleoff;


        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);

            status = itemView.findViewById(R.id.imgstatus);
            foodchaosuon = itemView.findViewById(R.id.food_chaosuon);
            imgminprice = itemView.findViewById(R.id.min_price);
            imgmaxprice = itemView.findViewById(R.id.max_price);
            imgsaleoff = itemView.findViewById(R.id.imageSaleoff);
            txttenmon= itemView.findViewById(R.id.txt_ten_mon);
            txtaddress = itemView.findViewById(R.id.txt_address);
            txtdetailaddress = itemView.findViewById(R.id.txt_detailAddress);
            txtminprice = itemView.findViewById(R.id.textViewMinPrice);
            txtmaxprice = itemView.findViewById(R.id.textviewMaxprice);
            txtsaleoff = itemView.findViewById(R.id.textViewSaleOff);
            txtcategory = itemView.findViewById(R.id.textViewCategory);
            linearcontainer_category =itemView.findViewById(R.id.linearContainerCategory);
            linearSaleoff = itemView.findViewById(R.id.linear_container_saleoff);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    /*Toast.makeText(view.getContext(), mArrFood.get(getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();*/

                    if(mOnClickListenerItem != null){
                        mOnClickListenerItem.onClick(getAdapterPosition());
                    }
                }
            });


        }
    }

    public void setOnItemClickListener(OnClickListenerItem mOnClickListenerItem){
        this.mOnClickListenerItem = mOnClickListenerItem;

    }
}
