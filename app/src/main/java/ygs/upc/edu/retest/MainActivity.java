package ygs.upc.edu.retest;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void click(View v){
       Toast.makeText(MainActivity.this,"机智一bi",Toast.LENGTH_SHORT).show();

    }
    public void dialog1(View v){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setTitle("一人之下第三季");
        dialog.setMessage("点击确定免费观看一人之下");
        dialog.setPositiveButton("确定",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "你在想pi吃", Toast.LENGTH_SHORT).show();
                          }
        });
        dialog.setNegativeButton("取消",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消无效，请点确定", Toast.LENGTH_SHORT).show();
            }
        });
      dialog.create();
      dialog.show();
    }
    private String[] item=new String[]{ "拘灵谴将","风后奇门","大罗洞观","神机百炼","双全手","神灵明","炁体源流","六库仙贼"};
    private int flag;
    public void dialog2(View V){
        AlertDialog.Builder dialog =new AlertDialog.Builder(this);
        dialog.setTitle("以下不属于八绝技的是：");
       dialog.setSingleChoiceItems(item,0, new DialogInterface.OnClickListener(){
           @Override
           public void onClick(DialogInterface dialog, int which) {
               Toast.makeText(MainActivity.this, "选择了"+item[which], Toast.LENGTH_SHORT).show();
               flag=which;
           }

       });
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                which=flag;
                if(which==5)
                Toast.makeText(MainActivity.this, "宝儿姐挖好了坟", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "小师叔送来一个赞", Toast.LENGTH_SHORT).show();
            }
        }
        );
      dialog.create();
      dialog.show();
    }
    boolean[] bools = {false,false,false,false,false,false,false};
    private int  sum;
    public void dialog3(View v){
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("一人之下出现了几种方言？");
        dialog.setMultiChoiceItems(new String[]{"四川话","北京话","天津话","粤语","东北话","陕西话","河南话"}, bools, new DialogInterface.OnMultiChoiceClickListener() {
           @Override
         public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                             bools[which] = isChecked;
                         }
       });
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
         @Override

            public void onClick(DialogInterface dialog, int which) {
             for(int i=0;i<bools.length;i++)
                 if(bools[i]) {
                     sum++;
                     bools[i] = false;
                 }
                 if(sum>5)   Toast.makeText(MainActivity.this, "居然记起"+sum+"个，老天师向你比心心", Toast.LENGTH_SHORT).show();
                 else if(sum>3) Toast.makeText(MainActivity.this, "能记住"+sum+"个，小师叔送来一个赞", Toast.LENGTH_SHORT).show();
                  else Toast.makeText(MainActivity.this, "才"+sum+"个，宝儿姐，埋了他", Toast.LENGTH_SHORT).show();
                sum=0;
                         }
       });
        dialog.create();
        dialog.show();
    }
    private String[] question=new String[]{"一念之插","凡夫俗子","不遥碧莲","不听八卦","一夜五百","机智一逼","大慈大悲","一贫如洗"};
    private String[] answer=new String[]{"zly","lts","zcl","zgq","jzl","fbb","xzz","wdz"};
     private Random rand=new Random(1);
     int r=0;
    public void dialog4(View V){
         r=rand.nextInt(8);


        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("对答如流");
        dialog.setMessage(question[r]);
        final EditText et = new EditText(this);
        et.setHint("请回答对应人物");
        et.setSingleLine(true);
        dialog.setView(et);

        dialog.setNegativeButton("取消",null);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              String mess=et.getText().toString();

                if(mess.equals(answer[r]))

                  Toast.makeText(MainActivity.this, "小师叔送来一个赞", Toast.LENGTH_SHORT).show();

              else
                  Toast.makeText(MainActivity.this, "宝儿姐挖好了坟", Toast.LENGTH_SHORT).show();

            }
        });
        dialog.create();
        dialog.show();
    }
     public void ceshi(View v){
         final Intent intent=new Intent(this,SecondActivity.class);
         intent.putExtra("answer","123");
         startActivityForResult(intent,1);

     }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1&&resultCode == 2){
            String acquiredData= data.getStringExtra("realna"); //获取回传的数据
            Toast.makeText(MainActivity.this,acquiredData,Toast.LENGTH_SHORT).show();
        }
    }
}
