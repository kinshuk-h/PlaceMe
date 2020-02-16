package in.ac.du.placeme.adapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

import in.ac.du.placeme.R;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {
    private AppCompatActivity context;
    private ArrayList<Pair<String, String>> items = new ArrayList<>();

    public ProfileAdapter(AppCompatActivity context) {
        this.context = context;
    }

    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        try {
            Pair<String, String> item = items.get(position);
            holder.label.setText(item.first);
            holder.text.setText(item.second);
        } catch (Exception e) {
            Log.d(ProfileAdapter.class.getName(), "error: " + e);
            e.printStackTrace();
        }
    }

    @Override public int getItemCount() { return items.size(); }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View root; ImageView base; TextView text, label;
        public ViewHolder(View root) {
            super(root); this.root = root;
            label = root.findViewById(R.id.label);
            text = root.findViewById(R.id.data);
        }
    }

    public void add(Pair<String, String> object) {
        items.add(object); notifyItemInserted(items.size()-1);
    }
}
