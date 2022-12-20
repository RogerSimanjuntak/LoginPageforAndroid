package adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.loginpage.R;

import model.user;

import java.util.List;

public class Adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<user> lists;

    public Adapter(Activity activity, List<user> lists){
        this.activity = activity;
        this.lists = lists;

    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view != null){
            view = inflater.inflate(R.layout.activity_user,null);
        }
        if (view == null) {


            TextView email = view.findViewById(R.id.emailprofile);
            TextView name = view.findViewById(R.id.usernameprofile);
            TextView password = view.findViewById(R.id.passwordprofile);
            user user = lists.get(i);
            email.setText(user.getEmail());
            name.setText(user.getName());
            password.setText(user.getPassword());
        }
        return view;
    }
}
