package dandy1988.list_view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> exampleArray = new ArrayList<>();
    ArrayList<Boolean> select = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exampleArray.add("first");
        select.add(false);
        exampleArray.add("second");
        select.add(false);
        exampleArray.add("third");
        select.add(false);
        exampleArray.add("forth");
        select.add(false);

        final AdapterListView adapterListView = new AdapterListView(exampleArray, select);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapterListView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Boolean select = !(adapterListView.selections.get(position));
                adapterListView.selections.set(position, select);
                adapterListView.notifyDataSetChanged();
            }
        });


        final EditText etAddString = (EditText) findViewById(R.id.et_input);
        Button btnAddItem = findViewById(R.id.btn_add_item);
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((etAddString.getText() != null) && (etAddString.getText().toString().equals("") != true)) {
                    exampleArray.add(etAddString.getText().toString());
                    select.add(false);
                    adapterListView.notifyDataSetChanged();
                }
            }
        });
        
        Button btnDelItem = findViewById(R.id.btn_delete_item);
        btnDelItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapterListView.deleteItems();
                adapterListView.notifyDataSetChanged();
            }
        });


    }


}
