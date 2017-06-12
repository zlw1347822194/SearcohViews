package zlw.com.searcohview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity {
    private String[] searcoh = {"hhhhh","cccccc","wwwwww","ddddd","aaaaa"};
    private SearchView main_searchview;
    private ListView main_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        main_searchview = (SearchView) findViewById(R.id.main_searchview);
        main_listview = (ListView) findViewById(R.id.main_listview);

        main_listview.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, searcoh));
        main_listview.setTextFilterEnabled(true);

        main_searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (!TextUtils.isEmpty(newText)){
                    main_listview.setFilterText(newText);
                }   else {
                    main_listview.clearChoices();
                }


                return false;
            }
        });


    }


}
