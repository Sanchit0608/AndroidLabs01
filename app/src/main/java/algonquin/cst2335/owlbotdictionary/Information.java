package algonquin.cst2335.owlbotdictionary;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Information extends AppCompatActivity {

    String def, type, example;
    TextView txtDef, txtExample, txtType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {

            def = extras.getString("def");
            type = extras.getString("type");
            example = extras.getString("example");


            txtDef = findViewById(R.id.def);
            txtExample = findViewById(R.id.example);
            txtType = findViewById(R.id.type);

            txtDef.setText(def);
            txtExample.setText(type);
            txtType.setText(example);

        }

    }
}