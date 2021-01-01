package com.example.recycleview;

import java.util.ArrayList;
import java.util.Arrays;

public class Food {

    private boolean status;//thuộc tính status ko cần viết hoa chữ cái đầu, tên lớp mới viết hoa chữ cái đầu

    private Integer image;

    private String name;

    private String[] arrrayAddress;

    private Integer minprice;

    private Integer price;

    private String saleoff;

    private String[] category;

    public Food(boolean status, Integer image, String name, String[] arrrayAddress, Integer minprice, Integer price, String saleoff, String[] category) {
        this.status = status;
        this.image = image;
        this.name = name;
        this.arrrayAddress = arrrayAddress;
        this.minprice = minprice;
        this.price = price;
        this.saleoff = saleoff;
        this.category = category;
    }

    public Food() {
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getArrrayAddress() {
        return arrrayAddress;
    }

    public void setArrrayAddress(String[] arrrayAddress) {
        this.arrrayAddress = arrrayAddress;
    }

    public Integer getMinprice() {
        return minprice;
    }

    public void setMinprice(Integer minprice) {
        this.minprice = minprice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getSaleoff() {
        return saleoff;
    }

    public void setSaleoff(String saleoff) {
        this.saleoff = saleoff;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Food{" +
                "status=" + status +
                ", image=" + image +
                ", name='" + name + '\'' +
                ", arrrayAddress=" + Arrays.toString(arrrayAddress) +
                ", minprice=" + minprice +
                ", price=" + price +
                ", saleoff='" + saleoff + '\'' +
                ", category=" + Arrays.toString(category) +
                '}';
    }

    public static ArrayList<Food> getMock(){
        return new ArrayList<>(Arrays.asList( new Food(true , R.drawable.chaosuon, " Cháo sườn trứng bắc thảo", new String[64], 20, 37, "Free Ship", new String[0]),
                new Food(false , R.drawable.banhmi, " Bánh Mì pate gan ", new String[] {"88 huỳnh tấn phát, q7"}, 15, 25, "", new String[]{"Quán Ăn","Ăn Vặt/Vỉa Hè"}),
                new Food(true , R.drawable.comtam, " Cơm Tấm Hoàng Mập", new String[]{"125 Nguyễn Tất Thành, q4"}, 25, 35, "Deal 12k", new String[]{}),
                new Food(true , R.drawable.comga, " Cơm gà Hải Nam", new String[]{"288 Trần Phú, Quận 10"}, 20, 37, "Free Ship", new String[]{}),
                new Food(true , R.drawable.khoga, "Khô Gà Lá chanh", new String[]{"255 Nguyễn Hữu Thọ, Quận 7"}, 20, 37, "", new String[]{"Quán Ăn","Ăn Vặt/Vỉa Hè"})
        ));
    }





}
