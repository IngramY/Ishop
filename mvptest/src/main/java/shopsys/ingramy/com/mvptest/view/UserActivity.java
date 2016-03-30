package shopsys.ingramy.com.mvptest.view;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationItem;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;

import butterknife.Bind;
import butterknife.ButterKnife;
import shopsys.ingramy.com.mvptest.R;

public class UserActivity extends Activity implements IUserView {

    @Bind(R.id.id)
    EditText id;
    @Bind(R.id.first)
    EditText first;
    @Bind(R.id.last)
    EditText last;
    @Bind(R.id.save)
    Button save;
    @Bind(R.id.load)
    Button load;
    @Bind(R.id.show)
    Button show;
    @Bind(R.id.bottomNavigation)
    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        BottomNavigationItem bottomNavigationItem = new BottomNavigationItem("Record", getResources().getColor(R.color.colorAccent), R.drawable.shadow);
        BottomNavigationItem bottomNavigationItem1 = new BottomNavigationItem("Like", getResources().getColor(R.color.colorPrimary), R.drawable.shadow);
        BottomNavigationItem bottomNavigationItem2 = new BottomNavigationItem("Like", getResources().getColor(R.color.colorPrimary), R.drawable.shadow);
        BottomNavigationItem bottomNavigationItem3 = new BottomNavigationItem("Like", getResources().getColor(R.color.colorPrimary), R.drawable.shadow);

        bottomNavigation.addTab(bottomNavigationItem);
        bottomNavigation.addTab(bottomNavigationItem1);
        bottomNavigation.addTab(bottomNavigationItem2);
        bottomNavigation.addTab(bottomNavigationItem3);

        bottomNavigation.setOnBottomNavigationItemClickListener(new BottomNavigationView.OnBottomNavigationItemClickListener() {
            @Override
            public void onNavigationItemClick(int index) {
                Toast.makeText(UserActivity.this, "Item " + index + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getID() {
        if (TextUtils.isEmpty(id.getText().toString())) {
            return 0;
        }else{
            try {
                return Integer.valueOf(id.getText().toString().trim());
            }catch (Exception e){
                return 0;
            }
        }
    }

    @Override
    public String getFristName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public void setLastName(String lastName) {

    }
}
