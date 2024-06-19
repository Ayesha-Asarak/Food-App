////package com.example.anoj.Activity.Adapter;
////
////import android.content.Context;
////import android.view.LayoutInflater;
////import android.view.View;
////import android.view.ViewGroup;
////import android.widget.ImageView;
////import android.widget.TextView;
////
////import androidx.annotation.NonNull;
////import androidx.recyclerview.widget.RecyclerView;
////
////import com.bumptech.glide.Glide;
////import com.bumptech.glide.load.resource.bitmap.CenterCrop;
////import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
////import com.example.anoj.Activity.Domain.Foods;
////import com.example.anoj.Activity.Helper.ChangeNumberItemsListener;
////import com.example.anoj.Activity.Helper.ManagementCart;
////import com.example.anoj.R;
////
////import java.util.ArrayList;
////
////public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder> {
////    ArrayList<Foods> list;
////    private ManagementCart managmentCart;
////    ChangeNumberItemsListener changeNumberItemsListener;
////
////
////    public CartAdapter(ArrayList<Foods>list, Context context,ChangeNumberItemsListener changeNumberItemsListener){
////        this.list = list;
////        managmentCart=new ManagementCart(context);
////        this.changeNumberItemsListener = changeNumberItemsListener;
////    }
////    @NonNull
////    @Override
////    public CartAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
////        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
////        return new viewholder(inflate);
////    }
////
////    @Override
////    public void onBindViewHolder(@NonNull CartAdapter.viewholder holder, int position) {
////        holder.title.setText(list.get(position).getTitle());
////        holder.feeEachItem.setText("$"+list.get(position).getPrice());
////        holder.totalEachItem.setText(list.get(position).getNumberInCart()+"*$"+(list.get(position).getNumberInCart()*list.get(position).getPrice()));
////        holder.num.setText(list.get(position).getNumberInCart()+"");
////
////        Glide.with(holder.itemView.getContext())
////                .load(list.get(position).getImagePath())
////                .transform(new CenterCrop(),new RoundedCorners(30))
////                .into(holder.pic);
////
////        holder.plusItem.setOnClickListener(v -> managmentCart.plusNumberItem(list, position, () -> {
////            notifyDataSetChanged();
////            changeNumberItemsListener.change();
////        }));
////        holder.minusItem.setOnClickListener(v -> managmentCart.minusNumberItem(list, position, () -> {
////            notifyDataSetChanged();
////            changeNumberItemsListener.change();
////        }));
////    }
////
////    @Override
////    public int getItemCount() {
////        return list.size();
////    }
////
////    public class viewholder extends RecyclerView.ViewHolder{
////        TextView title,feeEachItem,plusItem,minusItem;
////        ImageView pic;
////        TextView totalEachItem, num;
////        public viewholder(@NonNull View itemView){
////            super(itemView);
////
////            title=itemView.findViewById(R.id.titleTxt);
////          pic=itemView.findViewById(R.id.pic);
////            feeEachItem=itemView.findViewById(R.id.feeEachItem);
////            plusItem=itemView.findViewById(R.id.plusCartBtn);
////            minusItem=itemView.findViewById(R.id.minusCartBtn);
////            totalEachItem=itemView.findViewById(R.id.totalTxt);
////            num=itemView.findViewById(R.id.numTxt);
////        }
////    }
////}
//package com.example.anoj.Activity.Adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.resource.bitmap.CenterCrop;
//import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
//import com.example.anoj.Activity.Domain.Foods;
//import com.example.anoj.Activity.Helper.ChangeNumberItemsListener;
//import com.example.anoj.Activity.Helper.ManagementCart;
//import com.example.anoj.R;
//
//import java.util.ArrayList;
//
//public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {
//    private ArrayList<Foods> list;
//    private ManagementCart managementCart;
//    private ChangeNumberItemsListener changeNumberItemsListener;
//
//    public CartAdapter(ArrayList<Foods> list, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
//        this.list = list;
//        this.managementCart = new ManagementCart(context);
//        this.changeNumberItemsListener = changeNumberItemsListener;
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Foods food = list.get(position);
//
//        holder.title.setText(food.getTitle());
//        holder.feeEachItem.setText("$" + food.getPrice());
//        holder.totalEachItem.setText(food.getNumberInCart() + " * $" + (food.getNumberInCart() * food.getPrice()));
//        holder.num.setText(String.valueOf(food.getNumberInCart()));
//
//        Glide.with(holder.itemView.getContext())
//                .load(food.getImagePath())
//                .transform(new CenterCrop(), new RoundedCorners(30))
//                .into(holder.pic);
//
//        holder.plusItem.setOnClickListener(v -> managementCart.plusNumberItem(list, position, () -> {
//            notifyDataSetChanged();
//            changeNumberItemsListener.change();
//        }));
//
//        holder.minusItem.setOnClickListener(v -> managementCart.minusNumberItem(list, position, () -> {
//            notifyDataSetChanged();
//            changeNumberItemsListener.change();
//        }));
//    }
//
//    @Override
//    public int getItemCount() {
//        return list.size();
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        TextView title, feeEachItem, plusItem, minusItem, totalEachItem, num;
//        ImageView pic;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            title = itemView.findViewById(R.id.titleTxt);
//            pic = itemView.findViewById(R.id.pic);
//            feeEachItem = itemView.findViewById(R.id.feeEachItem);
//            plusItem = itemView.findViewById(R.id.plusCartBtn);
//            minusItem = itemView.findViewById(R.id.minusCartBtn);
//            totalEachItem = itemView.findViewById(R.id.totalTxt);
//            num = itemView.findViewById(R.id.numTxt);
//        }
//    }
//}
package com.example.anoj.Activity.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.anoj.Activity.Domain.Foods;
import com.example.anoj.Activity.Helper.ChangeNumberItemsListener;
import com.example.anoj.Activity.Helper.ManagmentCart;
import com.example.anoj.R;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.viewholder> {
     ArrayList<Foods> list;
    private ManagmentCart managmentCart;
    ChangeNumberItemsListener changeNumberItemsListener;

    public CartAdapter(ArrayList<Foods> list, Context context, ChangeNumberItemsListener changeNumberItemsListener) {
        this.list = list;
        managmentCart = new ManagmentCart(context);
        this.changeNumberItemsListener = changeNumberItemsListener;
    }

    @NonNull
    @Override
    public CartAdapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new viewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
//        Foods food = list.get(position);

        holder.title.setText(list.get(position).getTitle());
        holder.feeEachItem.setText("$" + (list.get(position).getNumberInCart()*list.get(position).getPrice()));
        holder.totalEachItem.setText(list.get(position).getNumberInCart() + " * $" + (list.get(position).getNumberInCart()*list.get(position).getPrice()));
        holder.num.setText(list.get(position).getNumberInCart()+"");

//        // Get reference to the Firebase Storage
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//        StorageReference storageReference = storage.getReference().child(food.getImagePath());

        // Load the image using Glide
        Glide.with(holder.itemView.getContext())
                .load(list.get(position).getImagePath())
                .transform(new CenterCrop(), new RoundedCorners(30))
                .into(holder.pic);


        holder.plusItem.setOnClickListener(v -> managmentCart.plusNumberItem(list, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));

        holder.minusItem.setOnClickListener(v -> managmentCart.minusNumberItem(list, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListener.change();
        }));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class viewholder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem, plusItem, minusItem;
        TextView totalEachItem, num;
        ImageView pic;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            plusItem = itemView.findViewById(R.id.plusCartBtn);
            minusItem = itemView.findViewById(R.id.minusCartBtn);
            totalEachItem = itemView.findViewById(R.id.totalTxt);
            num = itemView.findViewById(R.id.numberItemTxt);
        }
    }
}
