package kr.ac.kopo.dialogpractice;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btn1 = findViewById(R.id.btn1);
        ImageView fimg = findViewById(R.id.fimg);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String[] fooditems = {"냉면", "물냉면", "비빔냉면"};
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("니가 원하는거");
                dlg.setSingleChoiceItems(fooditems, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        btn1.setText(fooditems[which]);
                        if (which == 0) {
                            fimg.setImageResource(R.drawable.cn);
                        } else if (which == 1) {
                            fimg.setImageResource(R.drawable.wcn);
                        } else {
                            fimg.setImageResource(R.drawable.bcn);
                        }
                    }
                });
//                dlg.setItems(fooditems, new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        btn1.setText(fooditems[which]);
//                        if (which == 0) {
//                            fimg.setImageResource(R.drawable.cn);
//                        } else if (which == 1) {
//                            fimg.setImageResource(R.drawable.wcn);
//                        } else {
//                            fimg.setImageResource(R.drawable.bcn);
//                        }
//                    }
//                });
//                dlg.setMessage("wat is dis shiii");
                dlg.setIcon(R.mipmap.ic_launcher);
                dlg.setPositiveButton("닫 기", null);
//                dlg.setNegativeButton("취 소", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        Toast.makeText(MainActivity.this, "nope", Toast.LENGTH_SHORT).show();
//                    }
//                });
                dlg.show();
            }
        });
    }
}