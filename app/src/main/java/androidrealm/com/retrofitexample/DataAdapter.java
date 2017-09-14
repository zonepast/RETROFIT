package androidrealm.com.retrofitexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.ArrayList;
import java.util.List;



public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<ProductResponse> products;
    private Context context;
    private ImageView imageView;
    private Bitmap bitmap;

String prodImage;
    ProductResponse response;
    public DataAdapter(List<ProductResponse> products, Activity activity) {
        this.products = products;
        this.context = activity;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewholder, int i) {

         response = products.get(i);

        Picasso.with(context)
                .load("http://www.silvergiftz.com/images/product/" + response.getProdImage())
                .resize(400,400)
                .into(viewholder.prod_Image);
        viewholder.prod_num.setText(response.getProdname());
        viewholder.prod_name.setText(response.getProdNum());

    }

    @Override
    public int getItemCount() {

        return products.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView prod_num, prod_name;
        ImageView prod_Image;
       // Bitmap bmp;

        public View cardView;

        public ViewHolder(final View view) {
            super(view);

            prod_num = (TextView) view.findViewById(R.id.prod_num);
            prod_name = (TextView) view.findViewById(R.id.prod_name);
            prod_Image = (ImageView) view.findViewById(R.id.prod_image);
            cardView=(CardView) view.findViewById(R.id.cardview);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    response=products.get(getAdapterPosition());
                    prodImage=response.getProdImage();

                    Intent intent=new Intent(view.getContext(),NextActivity.class);

                   /* Bundle bundle=new Bundle();
                    bundle.putInt("image",prod_Image.getLeft());
                    intent.putExtras(bundle);*/

                    /*ByteArrayOutputStream bStream = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, bStream);
                    byte[] byteArray = bStream.toByteArray();*/


                    intent.putExtra("image",prodImage);


                    intent.putExtra("num",prod_num.getText());
                    intent.putExtra("name",prod_name.getText().toString());

                    view.getContext().startActivity(intent);

                }
            });






    }


    }
}
