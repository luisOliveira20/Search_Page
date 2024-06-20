package pt.ipp.estg.dwdn.pdm1.search_page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    SearchView searchView;
    ListView listView;
    TextView textView, textView2;
    ImageView imageView;
    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    String[] item = {"Toyota", "Honda", "Ford", "Chevrolet", "BMW", "Audi", "Mercedes-Benz", "Volkswagen", "Nissan", "Tesla"};

    AutoCompleteTextView AutoCompleteView;
    ArrayAdapter<String> adapterItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        listView = findViewById(R.id.list_view);
        textView = findViewById(R.id.search_page);
        textView2 = findViewById(R.id.textView3);
        imageView = findViewById(R.id.arrow_back);
        AutoCompleteView = findViewById(R.id.auto_complete_txt);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, item);

        AutoCompleteView.setAdapter(adapterItems);

        listView.setVisibility(View.GONE);

        arrayList = new ArrayList<>();
        arrayList.add("Toyota Supra MK4");
        arrayList.add("Honda Civic");
        arrayList.add("Hyundai");
        arrayList.add("BMW 116 d Line Sport");
        arrayList.add("Ford Mustang");
        arrayList.add("Chevrolet Comaro");
        arrayList.add("BMW 3 Series");
        arrayList.add("Audi A4");
        arrayList.add("Nissan Altima");
        arrayList.add("Tesla Model 3");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String s) {
                listView.setVisibility(View.VISIBLE);
                adapter.getFilter().filter(s);
                return false;
            }
        });

        AutoCompleteView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, "Item: " + item, Toast.LENGTH_SHORT).show();
            }
        });
    }
}