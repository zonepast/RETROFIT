package androidrealm.com.retrofitexample;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class NextActivity extends AppCompatActivity {
    private ImageView imageview1;
    private TextView textView1, textView2;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        imageview1 = (ImageView) findViewById(R.id.imageview1);
        textView1 = (TextView) findViewById(R.id.txtview1);
        textView2 = (TextView) findViewById(R.id.txtview2);
        //Bundle bundle = getIntent().getExtras();

        //byte[] byteArray = getIntent().getByteArrayExtra("image");
        //bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


        Bundle bundle=getIntent().getExtras();
        String image1=bundle.getString("image");


        Picasso.with(context)
                .load("http://www.silvergiftz.com/images/product/" + image1)
                .resize(500, 500)
                .into(imageview1);
        /*Bundle extras = getIntent().getExtras();
        Bitmap bmp2 = extras.getParcelable("image");
        ImageView result = (ImageView)findViewById(R.id.imageview1);
        result.setImageBitmap(bmp2);*/


        String num= bundle.getString("num");
        String name = bundle.getString("name");
        //String num = intent.getStringExtra("prod_num");
        //String name = intent.getStringExtra("prod_name");
        //textView1.setText("prod_num");
        //textView2.setText("prod_name");
        /*Toast.makeText(getApplicationContext(),"products are:"+"\n prod num"+num+
                "\n prod name "+name,Toast.LENGTH_LONG).show();*/
        textView1.setText(num);
        textView2.setText(name);
        //imageview1.setImageResource(image1);


    }
}
